<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.test.util.DateAndTime"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级相册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
</head>

<body>
		<%@include file="head.jsp" %>
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="panel panel-default">
						<div class="panel-body">
						   <s:iterator value="#request.photoList" id="id" status="st">
						   	<s:url id="url2" action="showPhoto">
						   		<s:param name="infoid" value="#id.Id"></s:param>
						   	</s:url>
						   	<div
						   		style="width:130px; height:150px; float:left; margin:4px; border:#EEEEEE solid 3px; text-align:center; display:inline; overflow:hidden;">
						   		<a href='UploadPhotos/<s:property value="#id.path"/>'
						   			target='_blank'>
						   			<div
						   				style="width:120px; height:90px; margin:5px; overflow:hidden; clear:both">
						   				<img src='UploadPhotos/<s:property value="#id.path"/>'
						   					width="120" height="90" border="0" />
						   			</div> 『<s:property value="#id.title" />』<br /> <font
						   			color="#AAAAAA">[<s:property value="#id.uploaddate" />]</font>
						   		</a>
						   	</div>
						   </s:iterator>
						</div>
					</div>
				</div>
				<%@include file="aside.jsp" %>
			</div>
		</div>
</body>
</html>
