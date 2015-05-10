package org.duohuo.action;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.struts2.ServletActionContext;
import org.duohuo.domain.User;
import org.duohuo.utils.JDBCUtils;



import com.opensymphony.xwork2.ActionSupport;

/**
 * 登陆
 * @author apple
 *
 */
public class LoginAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		// 1 获取用户名 和 密码
		String username = ServletActionContext.getRequest().getParameter("username");
		String password = ServletActionContext.getRequest().getParameter("password");
		
		// 2 判断是否正确
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where username =? and password =? ";
		User user = queryRunner.query(sql , new BeanHandler<User>(User.class),username,password);
		
		if(user == null){
			// 登陆失败
			ServletActionContext.getRequest().setAttribute("msg", "用户名或者密码错误！");
			return INPUT;
		}else{
			// 登陆成功
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return SUCCESS;
		}
	}
}
