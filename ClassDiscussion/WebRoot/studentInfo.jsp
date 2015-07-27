<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  isELIgnored="false" %>
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
<title>${stuinfo.sname}的个人主页</title>
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
                <div class="clearfix">
                    <img src="UploadImages/${stuinfo.image}" alt="logo" class="img-rounded pull-left" />
                    <ul class="list-group text-left">
                        <li class="list-group-item">姓名：${stuinfo.sname }</li>
                        <li class="list-group-item">年龄：${stuinfo.age }</li>
                        <li class="list-group-item">状态：${stuinfo.status }</li>
                        <li class="list-group-item">更改时间：${stuinfo.uptime }</li>
                        <li class="list-group-item">QQ：${stuinfo.qq }</li>
                        <li class="list-group-item">MSN：${stuinfo.msn }</li>
                        <li class="list-group-item">电话：${stuinfo.phone }</li>
                        <li class="list-group-item">宿舍：${stuinfo.dormitory }</li>
                    </ul>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">留言板</h3>
                    </div>
                    <div class="panel-body">
                        <s:iterator value="#request.msglist"  id="id" status="st">  
                        <s:url id="url2" action="showInfo"  >
                        <s:param name="infoid" value="#id.id"></s:param>     
                        </s:url>
                        <s:property value="#id.from"/>：<s:property value="#id.msg"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;<font color="CCCCCC">[<s:property value="#id.sendtime"/>]</font>
                        </s:iterator>
                    </div>
                    <div class="panel-footer clearfix">
                        <a href="showmsg.action?sno=" class="btn btn-primary pull-right">查看更多留言</a>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">给ta留言</h3>
                    </div>
                    <div class="panel-body">
                        <form action="addmsg.action" method="POST" role="form">
                             <input type="hidden" name="from" value="${student.sno}">
                             <input type="hidden" name="to" value="${stuinfo.sno}">
                             <label for="textarea">内容</label>
                            <div class="form-group"><textarea name="msg" id="textarea" cols="30" rows="10" class="form-control" row="3"></textarea></div>
                             <input type="submit" class="btn btn-success btn-block" value="发布留言" />
                        </form>
                    </div>
                </div>
            </div>
            <%@include file="asideSearch.jsp" %>
        </div>
    </div>
</body>
</html>
