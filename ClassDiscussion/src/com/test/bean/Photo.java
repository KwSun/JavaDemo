package com.test.bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.util.DBConnect;

public class Photo {

	private int id;
	private String title;
	private String content;
	private String uploaddate;
	private String path;
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
	
	
	
	public int addPhotoPath()
	{
		 int flag=-1;
			
		 String sql="insert into photo(path,title,content) values (?,?,?)";
		 DBConnect dbc;
		
		 try {
			 dbc=new DBConnect(sql);
			 dbc.setString(1,path);
			 dbc.setString(2,title);
			 dbc.setString(3,content);
			 
			 flag=dbc.executeUpdate();
			 
			 dbc.close();
		} catch (Exception e) {
			 return flag;
		}
		return flag;
		
	}
	
	
	public List<Photo> getIndexPhoto(boolean isLimited)
	{
		 List<Photo> photolist = new ArrayList<Photo>();
		 String sql;
		 if(isLimited)
		    sql="select Id,title,path,content,uploadDate from photo order by uploadDate desc limit 5";
		 else
			sql="select Id,title,path,content,uploadDate from photo order by uploadDate desc";
		 
		 
		 DBConnect dbc;
		 ResultSet rs=null;
		 
		 try {
			 dbc=new DBConnect();
			
			 rs=dbc.executeQuery(sql);
			 while(rs.next())
			 {
				 Photo photo= new Photo();
				 photo.setId(rs.getInt(1));
				photo.setTitle(rs.getString(2));;
				photo.setPath(rs.getString(3));
				 photo.setContent(rs.getString(4));
				 photo.setUploaddate(rs.getString(5));
				 photolist.add(photo);
			 }
			 dbc.close();
			 
		} catch (Exception e) {
			 return null;
		}
		 return photolist ;
		 
	}
	
	
}
