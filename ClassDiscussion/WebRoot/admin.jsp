<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="css/back.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <div align="left" style="text-align:left; margin:15px;">
    <a href="showinfolist.action?typeid=2" target="_blank">班级通知</a><br><br>
    <a href="showinfolist.action?typeid=1" target="_blank">学院通知</a><br><br>
    <a href="pubinfo.jsp" target="main">发布通知</a><br><br>
    <a href="addStudent.jsp" target="main">增加班级成员</a><br><br>
    <a href="uploadPhoto.jsp" target="main">上传相册照片</a><br><br>
    <a href="showPhoto.action" target="_blank">显示相册列表</a><br><br>
    <a href="login.jsp" target="_parent">返回</a>
  </div>
  </body>
</html>
