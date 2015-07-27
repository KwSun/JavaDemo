package com.test.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.Admin;

public class LoginAction extends ActionSupport {
	// 客户端直接调用set
	private String adminName;
	private String adminPwd;

	// 表单提交自动查询set方法
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String execute() throws Exception {
		Admin admin = new Admin();
		admin.setAdminName(adminName);
		admin.setAdminPwd(adminPwd);

		int flag = -1;
		flag = admin.login();
		if (flag == 1) {
			ActionContext ctx = ActionContext.getContext();
			Map session = ctx.getSession();
			session.put("admin", adminName);
			return SUCCESS;
		} else {
			this.addFieldError("", "用户名/密码错误，请重新登陆！");
			return INPUT;
		}
	}

}
