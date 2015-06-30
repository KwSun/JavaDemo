package org.kw.user.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import org.kw.user.domain.User;
import org.kw.user.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * 员工所有操作 （登陆、增删改查）
 * 
 * @author apple
 * 
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	/**
	 * 员工登陆
	 * 
	 * @return
	 */
	@InputConfig(resultName = "loginINPUT")
	// 修改workflow拦截器跳转视图
	public String login() {
		// 登陆数据 已经在 user中，传递业务层，查询
		UserService userService = new UserService();
		User logonUser = userService.login(user);
		// 判断是否登陆成功
		if (logonUser == null) {
			// 登陆失败
			this.addActionError(this.getText("loginfail"));
			return "loginINPUT";
		} else {
			// 登陆成功
			ServletActionContext.getRequest().getSession()
					.setAttribute("user", logonUser);
			return "loginSUCCESS";
		}
	}

	/**
	 * 员工添加
	 * 
	 * @return
	 * @throws IOException
	 */
	@InputConfig(resultName = "addINPUT")
	public String add() throws IOException {
		// 上传简历
		if (upload != null) {
			String uuidName = UUID.randomUUID().toString();
			String path = "/WEB-INF/upload/" + uuidName;
			File destFile = new File(ServletActionContext.getServletContext()
					.getRealPath(path));
			FileUtils.copyFile(upload, destFile);

			// 接收员工数据
			// 在user 保存 uuid文件路径 和 真实文件名
			user.setPath(path);
			user.setFilename(uploadFileName);
		}

		UserService userService = new UserService();
		userService.add(user);

		return "addSUCCESS";
	}

	private File upload;
	private String uploadContentType;
	private String uploadFileName; // 真实文件名

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * 员工列表查询
	 * 
	 * @return
	 */
	public String list() {
		// 所有添加参数都被封装 model对象
		UserService userService = new UserService();

		// 获得查询结果，将结果传递给jsp (值栈)
		users = userService.list(user);

		return "listSUCCESS";
	}

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	/**
	 * 员工删除
	 * 
	 * @return
	 */
	public String delete() {
		UserService userService = new UserService();
		// 删除简历
		user = userService.findById(user.getUserID());
		if (user.getPath() != null) {// 判断有简历删除
			File file = new File(ServletActionContext.getServletContext()
					.getRealPath(user.getPath()));
			file.delete();
		}

		// 删除数据库数据
		userService.delete(user);

		return "deleteSUCCESS";
	}

}
