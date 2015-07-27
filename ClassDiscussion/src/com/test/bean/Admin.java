package com.test.bean;

import java.sql.ResultSet;

import com.test.util.DBConnect;

/**
 * 管理员基本登陆，以及一些操作
 * 
 * @author apple
 * 
 */
public class Admin {

	private String adminName;
	private String adminPwd;

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

	/**
	 * 登陆
	 * 
	 * @param username用户名
	 * @param pwd密码
	 * @return返回标志，失败-1，成功1
	 */
	public int login() {
		int flag = -1;

		String sql = "select adminPwd from admin where adminName=?";
		DBConnect dbc;
		ResultSet rs = null;

		String adpwd = null;
		try {
			dbc = new DBConnect(sql);
			dbc.setString(1, adminName);
			rs = dbc.executeQuery();
			while (rs.next()) {
				adpwd = rs.getString(1);
			}
			dbc.close();
		} catch (Exception e) {
			return flag;
		}

		if (adpwd != null && adpwd.equals(adminPwd)) {
			flag = 1;
		}
		return flag;

	}

}
