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
    
    <title>My JSP 'MyInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
       
    <center>
   
   <form action="modifyinfo.action" method="post">
   
   <input type="hidden" name="sno" value="${student.sno }"/>
    学号:${student.sno }<br>
    姓名:<input type="text" name="sname" value="${student.sname }"><br>
    年龄 <input type="text" name="age" value="${student.age }"><br>
   性别 
   <input type="radio" name="sex" value="1" id="v1" 
   <s:if test="#session.student.sex==1">
     checked
   </s:if> ><label for="v1">男</label>
   <input type="radio" name="sex" value="0" id="v2"
   <s:if test="#session.student.sex==0">
     checked
   </s:if>
   
   ><label for="v2">女</label>
   
   <br>
   
   QQ<input type="text" name="qq" value="${student.qq }"><br>
   MSN<input type="text" name="msn" value="${student.msn }"><br>
    联系方式<input type="text" name="phone" value="${student.phone }"><br>
       宿舍<input type="text" name="domitory" value="${student.dormitory }"><br>
   <input type="submit" value="更改个人信息"/>
   </form>
   
   
   
      
       
       
    
       
       
       
      
       
    </center>      
       
  </body>
</html>
