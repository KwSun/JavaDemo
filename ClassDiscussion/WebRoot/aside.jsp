<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.test.util.DateAndTime"%>
	<div class="col-md-4">
	<div class="panel panel-default">
		<div class="panel-body">
			<%
				String ip = request.getHeader("x-forwarded-for");
				if (ip == null || ip.length() == 0
						|| "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("Proxy-Client-IP");
				}
				if (ip == null || ip.length() == 0
						|| "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("WL-Proxy-Client-IP");
				}
				if (ip == null || ip.length() == 0
						|| "unknown".equalsIgnoreCase(ip)) {
					ip = request.getRemoteAddr();
				}
			%>
		   <div id="loginfo">
		   	今天是：<br /><%=DateAndTime.getCurrentlyTime()%>
		   	<br /> 本次登录IP：<br /><%=ip%>
		   	<br />
		   	<a href="logOut.action">退出登录</a>
		   </div>
		   <div id="clock">
		   	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
		   		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0"
		   		width="95" height="95">
		   		<param name="movie" value="swf/clock.swf" />
		   		<param name="quality" value="high" />
		   		<embed src="swf/clock.swf" quality="high"
		   			pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"
		   			type="application/x-shockwave-flash" width="95" height="95"></embed>
		   	</object>
		   </div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-body">
		  <form name="classnotice" action="addClassInfo.action"
		  	method="post" class="form-horizontal">
		  	<div class="form-group">
		  		<label  for="title" class="col-sm-3 control-label">标题</label>
		  		<div class="col-sm-9">
		  			<input type="text" class="form-control" id="title" name="title" >
		  		</div>
		  	</div>
		  	<div class="form-group">
		  		<label for="content" class="col-sm-3 control-label">内容</label>
		  		<div class="col-sm-9">
		  			<textarea name="content" rows="3" class="form-control"></textarea>
		  		</div>
		  	</div>
		  	<input type="submit" class="btn btn-primary btn-sm" value="喊一嗓子" style="margin-left:-80px;" />
		  </form>
		</div>
	</div>
	</div>