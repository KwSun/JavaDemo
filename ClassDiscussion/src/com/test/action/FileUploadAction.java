package com.test.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.Classmate;
import com.test.bean.Photo;

public class FileUploadAction extends ActionSupport  {
    private static final long serialVersionUID = 572146812454l ;
    private static final int BUFFER_SIZE = 16 * 1024 ;
    
   
    //单文件上传
    private File myFile;
    private String contentType;
    private String fileName;
    private String imageFileName;
    private String caption;
    
    //多文件上传
    private List<File> file; 
    private List<String> fileFileName; 
    private List<String> fileContentType;
    private List<String> phototitle;
    private List<String> photodescribe;
   
    public void setMyFileContentType(String contentType)  {
        this .contentType = contentType;
   } 
   
    public void setMyFileFileName(String fileName)  {
        this .fileName = fileName;
   } 
       
    public void setMyFile(File myFile)  {
        this .myFile = myFile;
   } 
   
    public String getImageFileName()  {
        return imageFileName;
   } 
   
    public String getCaption()  {
        return caption;
   } 

     public void setCaption(String caption)  {
        this .caption = caption;
   } 
   
    public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public List<String> getPhototitle() {
		return phototitle;
	}

	public void setPhototitle(List<String> phototitle) {
		this.phototitle = phototitle;
	}

	public List<String> getPhotodescribe() {
		return photodescribe;
	}

	public void setPhotodescribe(List<String> photodescribe) {
		this.photodescribe = photodescribe;
	}

	private static void copy(File src, File dst)  {
        try  {
           InputStream in = null ;
           OutputStream out = null ;
            try  {                
               in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
               out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                byte [] buffer = new byte [BUFFER_SIZE];
                while (in.read(buffer) > 0 )  {
                   out.write(buffer);
               } 
            } finally  {
                if ( null != in)  {
                   in.close();
               } 
                 if ( null != out)  {
                   out.close();
               } 
           } 
        } catch (Exception e)  {
           e.printStackTrace();
       } 
   } 
   
    private static String getExtention(String fileName)  {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos);
   } 

   //单文件上传
    public String uploadImage() {    
    	
    	ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		Classmate student =(Classmate)session.get("student");
		
		if(student==null)
		{
			this.addFieldError("","错误信息:未登录无法上传头像，请先登录!");
			return LOGIN;
		}else{
			 imageFileName = new Date().getTime() + getExtention(fileName);
		     File imageFile = new File(ServletActionContext.getServletContext().getRealPath( "/UploadImages" ) + "/" + imageFileName);
		     copy(myFile, imageFile);
		     
		     Classmate stu=new Classmate();
		     stu.setSno(student.getSno());
		     stu.setImage(imageFileName);
		     int flag=-1;
		     flag=stu.uploadImage();
		     if(flag!=-1){
		    	  student.setImage(imageFileName);
		          return SUCCESS;
		     }else{
		    	 this.addFieldError("","错误信息:上传头像失败，请重新进行操作!");
					return ERROR;
		     }
			
		}
    
   } 
    
    //多文件上传
    public String uploadPhoto(){

        Photo photo = new Photo();
        
    	try {
			
    	   for(int i=0;i<file.size();i++){ 
    		
    		 imageFileName = new Date().getTime() + getExtention(fileFileName.get(i));
  		     File imageFile = new File(ServletActionContext.getServletContext().getRealPath( "/UploadPhotos" ) + "/" + imageFileName);
  		     copy(file.get(i), imageFile);
  		     photo.setPath(imageFileName);
  		     photo.setTitle(phototitle.get(i));
  		     photo.setContent(photodescribe.get(i));
  		     System.out.println();
  		     System.out.println("A   "+phototitle.get(i)+"  B "+photodescribe.get(i) );
  		     photo.addPhotoPath();
    	   } 
    	   
    	} catch (Exception e) {
    		 this.addFieldError("","错误信息:上传图片失败，请重新进行操作!");
    		 return ERROR;
		}
   
    	   return SUCCESS;
    	 
    }

    
    
   
} 
