<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
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
				<form action="login.action" method="POST" role="form" name="loginform" class="form-horizontal">
					<legend>管理员登陆</legend>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">账号</label>
						<div class="col-md-10">
							<input type="text" class="form-control" id="name" name="adminName">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-md-10">
							<input type="password" class="form-control" id="password" name="adminPwd">
						</div>
					</div>
					<div class="form-group col-offset-2">
						<a href="javascript:loginform.submit()" class="btn btn-success" onclick="javascript:this.submit()">登陆</a>
						<a href="javascript:window.parent.close()" class="btn btn-danger">取消</a>
					</div>
				</form>
			</div>
		</div>
</div>

</body>
</html>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>&#31649;&#29702;&#21592;&#30331;&#24405;</title>
<link href="css/back.css" rel="stylesheet" type="text/css">
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
<tr><td align="center" valign="middle">
<form action="login.action">
<div id="main_log">
<div class="part"></div>
<div class="part">AdminLogin</div>
<div class="part"></div>
<div class="part">UID: <input type="text" class="text" name="adminName" /></div>
<div class="part"></div>
<div class="part">PWD: <input type="password" class="text" name="adminPwd" /></div>
<div class="part"></div>
<div class="part"><input type="submit" value="Check" class="button" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" onClick="window.location.href('login.jsp')" value="Leave" class="button" /></div>
<div class="part"></div>
<div class="part"><FONT color="#666666"><s:fielderror></s:fielderror></FONT></div>
</div>
</form>
</center>
</td></tr>
</table>
</body> -->

</html>