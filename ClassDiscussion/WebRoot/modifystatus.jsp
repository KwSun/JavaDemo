<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.test.util.*,com.test.bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifystatus.jsp' starting page</title>
    
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
   <%
   out.clear();
   
   request.setCharacterEncoding("UTF-8");
   //String status=new String(request.getParameter("state").getBytes("ISO-8859-1"),"GB2312");
   String status = request.getParameter("state"); //晕死了这地方
   String sno =  request.getParameter("sno");
   
   Classmate stu = new Classmate();
   stu.modifyStatus(status,sno);
   
   %>
   <%=status%>
  </body>
</html>
