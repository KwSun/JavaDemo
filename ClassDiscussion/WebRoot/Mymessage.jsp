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
<title>留言板</title>
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
					<div class="panel panel-primary">
						  <div class="panel-heading">
								<h3 class="panel-title">留言板</h3>
						  </div>
						  <div class="panel-body">
								<s:iterator value="#request.msglist"  id="id" status="st">  
								    <s:url id="url2" action="showInfo"  >
								    	<s:param name="infoid" value="#id.id"></s:param>   
								    </s:url>
									<div class="panel-footer">
										<s:property value="#id.from"/>：<s:property value="#id.msg"/>
										<br />&nbsp;&nbsp;&nbsp;&nbsp;
										<font color="CCCCCC">[<s:property value="#id.sendtime"/>]</font>
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
