<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.test.util.DateAndTime" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级成员</title>
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
        <%@include file="head.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="panel panel-default">
                          <div class="panel-heading clearfix">
                                <ol class="breadcrumb pull-left">
                                  
        <s:form action ="fileUpload" method ="POST" enctype ="multipart/form-data" > 
        <s:file styleClass="clnotice_title" name="myFile" label ="图片路径" />    
        <s:submit styleClass="clnotice_submit" label="上传头像"/> 
    	</s:form > 

                                </ol>
                          </div>
                          
                    </div>
                </div>
                <%@include file="asideSearch.jsp" %>
            </div>
        </div>
</html>
