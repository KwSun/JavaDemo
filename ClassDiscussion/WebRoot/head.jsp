<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.test.util.DateAndTime"%>

<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="row">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">${student.sname }的个人主页</a>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="studentlogin.action">个人首页</a></li>
					<li><a href="http://www.nuist.edu.cn/" target="_blank">信大首页</a></li>
					<li><a href="MyInfo.jsp">个人信息</a></li>
					<li><a href="showPhoto.action">班级相册</a></li>
					<li><a href="showmsg.action?sno=${student.sno}">留言板</a></li>
					<li><a href="showstudentlist.action">班级成员</a></li>
					<li><a href="showinfolist.action?typeid=2">班级通知</a></li>
					<li><a href="showinfolist.action?typeid=1">学院通知</a></li>
				</ul>
			</div>
		</div>
	</div>
</nav>