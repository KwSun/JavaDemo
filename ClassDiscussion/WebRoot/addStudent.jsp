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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页</title>
<link href="css/back.css" rel="stylesheet" type="text/css" />
</head>

<body bgcolor="#F6F6F6">
<div style="margin:20px; text-align:left">
   <form action="addStudent.action" method="post">
   
  
   NO:<input type="text" name="sno" class="text" value=""><br><br>
    Name:<input type="text" name="sname" class="text" value=""><br><br>
   Age:<input type="text" name="age" class="text" value=""><br><br>
Sex:
   <input type="radio" name="sex" value="1" id="v1" checked><label for="v1">Male</label>
   <input type="radio" name="sex" value="0" id="v2"><label for="v2">Female</label>
   <br><br>
   QQ:<input type="text" name="qq" class="text" value=""><br><br>
   MSN:<input type="text" name="msn" class="text" value=""><br><br>
   TEL:<input type="text" name="phone" class="text" value=""><br><br>
   Dorm:<input type="text" name="domitory" class="text" value=""><br><br>
   <input type="submit" class="button" value="Add"/>
   </form>
</div>
</body>

</html>
