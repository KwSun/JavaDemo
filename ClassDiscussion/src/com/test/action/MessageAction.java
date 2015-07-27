package com.test.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.Classmate;
import com.test.bean.Info;
import com.test.bean.Message;

public class MessageAction extends ActionSupport {

	private String sno;
	private String from;
	private String to;
	private String msg;
	
	private List<Message> msglist;
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/*
	 * 显示个人信息
	 */
	public String showMyInfo()
	{
		if (sno == null) {
			this.addFieldError("", "错误信息:学号不能为空，请重新请求");
			return ERROR;
		} else {
		
			Message msg = new Message();
			msg.setTo(sno);
			msglist=msg.getMsgList(false);
			if (msglist != null) {
				return SUCCESS;
			} else {
				this.addFieldError("", "错误信息:获取学生信息失败，请重新请求");
				return ERROR;
			}

		}
	}
	
	/**
	 * 发布信息
	 * @return
	 */
	public String addMessage()
	{

		if(from==null || to==null)
		{
			this.addFieldError("","错误信息:未登录无法发布信息，请先登录!");
			return LOGIN;
		}else{
			
			Message mes = new Message();
			mes.setFrom(from);
			mes.setTo(to);
			mes.setMsg(msg);
			
			int flag=-1;
			flag=mes.addMsg();
			if(flag!=-1)
			{
			    this.addFieldError("","提示信息:留言成功!");
			    return SUCCESS;
			}else{
				this.addFieldError("","错误信息:留言失败2，请重新进行操作!"+from+"  "+to+"  "+msg);
				return ERROR;
			}
			
		}
	}
	
	
	
	
	
}
