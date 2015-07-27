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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="css/login.css" rel="stylesheet" type="text/css" />
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
	<div class="container">
		<div class="row">
			<div class="center-block content">
				<form action="studentlogin.action" method="POST" role="form" name="loginform" class="form-horizontal">
					<legend>用户登陆</legend>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">账号</label>
						<div class="col-md-10">
							<input type="text" class="form-control" id="name" name="sno">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-md-10">
							<input type="password" class="form-control" id="password" name="pwd">
						</div>
					</div>
					<div class="form-group col-offset-2">
						<a href="javascript:loginform.submit()" class="btn btn-success" onclick="javascript:this.submit()">登陆</a>
						<a href="javascript:window.parent.close()" class="btn btn-danger">取消</a>
					</div>
					<a href="adminlogin.jsp" class="pull-right">管理员登录</a>
				</form>
			</div>
		</div>
</div>

</body>
</html>
