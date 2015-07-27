package com.test.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.Classmate;
import com.test.bean.Info;

public class InfoAction extends ActionSupport {

	private int infoid;
	private int typeid;
    private List<Info> infoList;
	private String title;
	private String content;
    
	private Info info;
	
	public List<Info> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<Info> infoList) {
		this.infoList = infoList;
	}

	public int getInfoid() {
		return infoid;
	}

	public void setInfoid(int infoid) {
		this.infoid = infoid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	
	public String showInfoList()
	{
		if(typeid==0)
		{
			this.addFieldError("","错误信息:类型ID不能为空，请重新请求");
			return ERROR;
		}
			
		
		Info info = new Info();
		infoList = info.getInfo(typeid,false);
		if(infoList!=null)
		{
			return SUCCESS;
		}else{
			this.addFieldError("","错误信息:获取信息列表失败，请重新请求");
			return ERROR;
		}
		
	}
	public String addClassInfo() throws UnsupportedEncodingException
	{
		
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		Classmate student =(Classmate)session.get("student");
		
		if(student==null)
		{
			this.addFieldError("","错误信息:未登录无法发布信息，请先登录!");
			return LOGIN;
		}else{
			Info info = new Info();
			
			System.out.println(title+"  A "+content);
			info.setTitle(title);
			info.setContent(content);
			info.setAuthor(student.getSname());
			info.setTypeid(2);
			System.out.println(student.getSname());
			int flag=-1;
			flag=info.addInfo();
			if(flag!=-1)
			{
			    this.addFieldError("","提示信息:发布信息成功!");
			    return SUCCESS;
			}else{
				this.addFieldError("","错误信息:发布信息失败2，请重新进行操作!");
				return ERROR;
			}
			
		}
	}
	
	
	
	public String adminAddInfo()
	{
		
//		ActionContext ctx = ActionContext.getContext();
//		Map session = ctx.getSession();
//		Classmate student =(Classmate)session.get("student");
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		String admin = (String)session.get("admin");
		
		if(admin == null)
		{
			this.addFieldError("","错误信息:管理员请先登陆!");
			return INPUT;
		}
		
		
		
		if(typeid==0)
		{
			this.addFieldError("","错误信息:类型ID不能为空，请重新请求");
			return ERROR;
		}else{
			Info info = new Info();

			info.setTitle(title);
			info.setContent(content);
			info.setAuthor(admin);
		    info.setTypeid(typeid);
			int flag=-1;
			
			flag=info.addInfo();
			if(flag!=-1)
			{
			    this.addFieldError("","提示信息:发布信息成功!");
			    return SUCCESS;
			}else{
				this.addFieldError("","错误信息:发布信息失败2，请重新进行操作!");
				return ERROR;
			}
			
		}
	}
	public String showInfo() {

		if (infoid == 0) {
			this.addFieldError("", "错误信息:通知ID不能为空，请重新请求");
			return ERROR;
		} else {
            Info theinfo = new Info();
			info = theinfo.getInfo(infoid);
			if (info != null) {
				return SUCCESS;
			} else {
				this.addFieldError("", "错误信息:获取信息列表失败，请重新请求");
				return ERROR;
			}

		}
	}
	
	public String deleteInfo() {

		if (infoid == 0) {
			this.addFieldError("", "错误信息:通知ID不能为空，请重新请求");
			return ERROR;
		} else {
            Info theinfo = new Info();
            theinfo.setId(infoid);
			int flag = -1;
            
			flag=theinfo.deleteinfo();
            
			if (flag!=-1) {
				this.addFieldError("", "成功删除信息！");
				return SUCCESS;
			} else {
				this.addFieldError("", "错误信息:获取信息列表失败，请重新请求");
				return ERROR;
			}

		}
	}
	
	
	
	
}
