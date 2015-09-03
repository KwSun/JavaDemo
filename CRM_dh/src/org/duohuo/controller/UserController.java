package org.duohuo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.duohuo.entity.PageBean;
import org.duohuo.entity.User;
import org.duohuo.service.UserService;
import org.duohuo.util.ResponseUtil;
import org.duohuo.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 用户控制层
 * @author Kw
 *
 * Date: 2015年9月3日
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	/**
	 * 用户登陆功能
	 * @param user
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest httpServletRequest) throws Exception{
		User resultUser = userService.login(user);
		if (resultUser == null) {
			httpServletRequest.setAttribute("user", user);
			httpServletRequest.setAttribute("errorMsg", "用户名或密码错误");
			return "login";
		}else {
			HttpSession httpSession = httpServletRequest.getSession();
			httpSession.setAttribute("currentUser", resultUser);
			return "redirect:/main.jsp";
		}
	}
	
	
	/**
	 * 分页条件查询用户
	 * @param page
	 * @param rows
	 * @param s_user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,User s_user,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userName", StringUtil.formatLike(s_user.getUserName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<User> userList=userService.find(map);
		Long total=userService.getTotal(map);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(userList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
