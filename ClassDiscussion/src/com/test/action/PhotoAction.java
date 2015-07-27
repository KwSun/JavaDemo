package com.test.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.Photo;

public class PhotoAction extends ActionSupport {
	private int id;
	private String title;
	private String content;
	private String uploaddate;
	private String path;
	
	 private List<Photo> photoList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public List<Photo> getPhotoList() {
		return photoList;
	}
	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}
	public String getPhotosList()
	{
		Photo photo = new Photo();
		photoList = photo.getIndexPhoto(false);
		
		if(photoList!=null)
		{
			return SUCCESS;
		}else{
			this.addFieldError("", "错误信息:获取照片信息失败，请重新进行操作!");
			return ERROR;
		}
		
	}
}
