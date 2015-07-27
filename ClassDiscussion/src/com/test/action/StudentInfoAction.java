package com.test.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.Classmate;
import com.test.bean.Message;

public class StudentInfoAction extends ActionSupport {

	private List<Classmate> studentlist;
	private List<Message> msglist;
	private Classmate stuinfo;
	private String sno;

	public List<Classmate> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Classmate> studentlist) {
		this.studentlist = studentlist;
	}

	public Classmate getStuinfo() {
		return stuinfo;
	}

	public void setStuinfo(Classmate stuinfo) {
		this.stuinfo = stuinfo;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public List<Message> getMsglist() {
		return msglist;
	}

	public void setMsglist(List<Message> msglist) {
		this.msglist = msglist;
	}

	public String showStudentList() {
		Classmate student = new Classmate();
		studentlist = student.getStudentList();
		if (studentlist != null) {
			return SUCCESS;
		} else {
			this.addFieldError("", "错误信息:获取班级成员列表失败，请重新请求");
			return ERROR;
		}

	}

	public String showStudentInfo() {
		if (sno == null) {
			this.addFieldError("", "错误信息:学号不能为空，请重新请求");
			return ERROR;
		} else {
			Classmate thestu = new Classmate();
			thestu.setSno(sno);
			try {
				stuinfo = thestu.getStudent();
				Message msg = new Message();
				msg.setTo(sno);
				msglist = msg.getMsgList(false);
				return SUCCESS;
			} catch (Exception e) {
				this.addFieldError("", e.toString());
				return ERROR;
			}
		}
	}
}
