package org.duohuo.service.impl;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.duohuo.dao.UserDao;
import org.duohuo.entity.User;
import org.duohuo.service.UserService;
import org.springframework.stereotype.Service;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年9月3日 下午3:13:40 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	@Override
	public User login(User user) {
		return userDao.login(user);
		
	}
	
	/**
	 * 查询用户集合
	 * @param map
	 * @return
	 */
	@Override
	public List<User> find(Map<String, Object> map) {
		return userDao.find(map);
		
	}
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	@Override
	public Long getTotal(Map<String, Object> map) {
		return userDao.getTotal(map);
		
	}
}
