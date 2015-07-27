package com.test.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.Classmate;
import com.test.bean.Info;
import com.test.bean.Message;
import com.test.bean.Photo;

public class StudentLoginAction extends ActionSupport {

	private int id;
	private String sno;//账号
	private String pwd;
	private String sname;//真实姓名
	private String status;
	private int age;
	private int sex;
	private String qq;
	private String msn;
	private String phone;
	private String domitory;

	// 以下用于修改判定是否,以及修改密码
	private int changepwd;
	private String newpwd;
	private String renewpwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDomitory() {
		return domitory;
	}

	public void setDomitory(String domitory) {
		this.domitory = domitory;
	}


	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String getRenewpwd() {
		return renewpwd;
	}

	public void setRenewpwd(String renewpwd) {
		this.renewpwd = renewpwd;
	}

	public int getChangepwd() {
		return changepwd;
	}

	public void setChangepwd(int changepwd) {
		this.changepwd = changepwd;
	}

	
	
	private List<Info> claInfoList;//学院通知列表
	private List<Info> acaInfoList;//班级通知列表

	private List<Classmate> statusList;//成员列表
	private List<Photo> photoList;//照片列表

	private List<Message> messagelist;//信息列表

	public List<Info> getClaInfoList() {
		return claInfoList;
	}

	public void setClaInfoList(List<Info> claInfoList) {
		this.claInfoList = claInfoList;
	}

	public List<Info> getAcaInfoList() {
		return acaInfoList;
	}

	public void setAcaInfoList(List<Info> acaInfoList) {
		this.acaInfoList = acaInfoList;
	}

	public List<Classmate> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Classmate> statusList) {
		this.statusList = statusList;
	}

	public List<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}

	public List<Message> getMessagelist() {
		return messagelist;
	}

	public void setMessagelist(List<Message> messagelist) {
		this.messagelist = messagelist;
	}

	public String execute() throws Exception {

		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		Classmate testStu = (Classmate) session.get("student");
		if (testStu == null) {

			Classmate student2 = new Classmate();
			student2.setSno(sno);
			student2.setPwd(pwd);

			int flag = -1;
			flag = student2.login();
			if (flag != -1) {
				student2 = student2.getStudent();
				if (student2 != null) {
					session.put("student", student2);
					Info info = new Info();
					claInfoList = info.getInfo(2, true);
					acaInfoList = info.getInfo(1, true);
					statusList = student2.getStudentStatusList();
					session.put("statusList", statusList);
					Photo photo = new Photo();
					photoList = photo.getIndexPhoto(true);

					Message msg = new Message();
					msg.setTo(sno);
					messagelist = msg.getMsgList(true);

					return SUCCESS;

				} else {
					this.addFieldError("", "系统错误，请重新登陆！");
					return INPUT;
				}
			} else {
				this.addFieldError("", "用户名/密码错误，请重新登陆！");
				return INPUT;
			}

		} else {

			Info info = new Info();
			claInfoList = info.getInfo(2, true);
			acaInfoList = info.getInfo(1, true);
			statusList = testStu.getStudentStatusList();
			session.put("statusList", statusList);
			Photo photo = new Photo();
			photoList = photo.getIndexPhoto(true);

			Message msg = new Message();
			msg.setTo(testStu.getSno());
			messagelist = msg.getMsgList(true);

			return SUCCESS;
		}
	}

	public String logOut() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		session.remove("student");
		return SUCCESS;
	}

	public String modifyinfo() throws Exception {

		if (changepwd == 0) {
			Classmate cla = new Classmate();
			cla.setSno(sno);
			cla.setSname(sname);
			cla.setSex(sex);
			cla.setAge(age);
			cla.setMsn(msn);
			cla.setPhone(phone);
			cla.setQq(qq);
			cla.setDormitory(domitory);

			int flag = -1;

			flag = cla.modifyInfo(false);
			if (flag != -1) {
				cla = cla.getStudent();
				ActionContext ctx = ActionContext.getContext();
				Map session = ctx.getSession();
				session.put("student", cla);

				this.addFieldError("", "个人信息更新成功！");
				return SUCCESS;
			} else {
				this.addFieldError("", "用户名/密码错误，请重新登陆！");
				return INPUT;
			}
		} else if (changepwd == 1) {
			if (newpwd == null || renewpwd == null || newpwd.equals("") || renewpwd.equals("") || !newpwd.equals(renewpwd)) {
				this.addFieldError("", "新密码以及确认密码不一致，修改信息失败，请重新修改！");
				return INPUT;
			}

			Classmate student2 = new Classmate();
			student2.setSno(sno);
			student2.setPwd(pwd);
			int flag = -1;
			flag = student2.login();

			if (flag != -1) {
				Classmate cla = new Classmate();
				cla.setSno(sno);
				cla.setSname(sname);
				cla.setPwd(newpwd);
				cla.setSex(sex);
				cla.setAge(age);
				cla.setMsn(msn);
				cla.setPhone(phone);
				cla.setQq(qq);
				cla.setDormitory(domitory);

				flag = -1;

				flag = cla.modifyInfo(true);
				if (flag != -1) {
					cla = cla.getStudent();
					ActionContext ctx = ActionContext.getContext();
					Map session = ctx.getSession();
					session.put("student", cla);

					this.addFieldError("", "个人信息更新成功！");
					return SUCCESS;
				} else {
					this.addFieldError("", "修改信息失败，请重新进行操作！");
					return INPUT;
				}

			} else {
				this.addFieldError("", "旧密码错误，修改密码错误失败！");
				return INPUT;
			}

		} else {
			return INPUT;
		}

	}

	/**
	 * 添加成员
	 * @return
	 * @throws Exception
	 */
	public String addStudent() throws Exception {
		Classmate cla = new Classmate();
		cla.setSno(sno);
		cla.setPwd(sno);
		cla.setSname(sname);
		cla.setSex(sex);
		cla.setAge(age);
		cla.setMsn(msn);
		cla.setPhone(phone);
		cla.setQq(qq);
		cla.setDormitory(domitory);


		String flag = cla.addStudent();
		if (flag.equals("success")) {

			this.addFieldError("", "添加班级成员成功！");
			return SUCCESS;
		} else {
			this.addFieldError("", flag + "添加班级成员失败！" + "    " + sno + "     ");
			return ERROR;
		}

	}

}
