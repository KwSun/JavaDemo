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
		<div class="panel-heading">
			<form action="http://www.google.cn/custom" method="get" class="form-inline" role="form" target="_blank">
				<div class="form-group">
					<label class="sr-only" for="">label</label>
					<input type="text" class="form-control" id="" name="q">
				</div>
				<input type="submit" class="btn btn-primary" name="sa" value="Google一下~"></input>
				<input type="hidden" name="client"
					value="pub-8160955626389853"></input> <input type="hidden"
					name="forid" value="1"></input> <input type="hidden"
					name="ie" value="utf-8"></input> <input type="hidden"
					name="oe" value="utf-8"></input> <input type="hidden"
					name="cof"
					value="GALT:#008000;GL:1;DIV:#336699;VLC:663399;AH:center;BGC:FFFFFF;LBGC:336699;ALC:0000FF;LC:0000FF;T:000000;GFNT:0000FF;GIMP:0000FF;FORID:1;"></input>
				<input type="hidden" name="hl" value="zh-CN"></input>
			</form>
		</div>
		<div class="panel-body">
		 	<table class="table table-hover">
		 		<tbody>
		 			<tr>
		 				<td><a href="http://www.nuist.edu.cn/" target="_blank"> 信大首页</a></td>
		 				<td><a href="http://cs.nuist.edu.cn/" target="_blank">软件学院</a></td>
		 				<td><a href="http://www.duohuo.org/" target="_blank">多火</a></td>
		 				<td><a href="http://www.duohuo.org/" target="_blank">多火</a></td>
		 			</tr>
		 			<tr>
		 				<td><a href="http://www.nuist.edu.cn/" target="_blank"> 信大首页</a></td>
		 				<td><a href="http://cs.nuist.edu.cn/" target="_blank">软件学院</a></td>
		 				<td><a href="http://www.duohuo.org/" target="_blank">多火</a></td>
		 				<td><a href="http://www.duohuo.org/" target="_blank">多火</a></td>		 			
		 			</tr>
		 			<tr>
		 				<td><a href="http://www.sohu.com/" target="_blank"> 搜狐</a></td>
		 				<td><a href="http://www.qq.com" target="_blank"> 腾讯</a></td>
		 				<td><a href="http://www.sohu.com/" target="_blank"> 搜狐</a></td>
		 				<td><a href="http://www.sohu.com/" target="_blank"> 搜狐</a></td>
		 			</tr>
		 			<tr>
		 				<td><a href="http://www.nuist.edu.cn/" target="_blank"> 信大首页</a></td>
		 				<td><a href="http://cs.nuist.edu.cn/" target="_blank">软件学院</a></td>
		 				<td><a href="http://www.duohuo.org/" target="_blank">多火</a></td>
		 				<td><a href="http://www.duohuo.org/" target="_blank">多火</a></td>
		 			</tr>
		 			<tr>
		 				<td><a href="http://www.nuist.edu.cn/" target="_blank"> 信大首页</a></td>
		 				<td><a href="http://cs.nuist.edu.cn/" target="_blank">软件学院</a></td>
		 				<td><a href="http://www.duohuo.org/" target="_blank">多火</a></td>
		 				<td><a href="http://www.duohuo.org/" target="_blank">多火</a></td>
		 			</tr>
		 			<tr>
		 				<td><a href="http://www.sohu.com/" target="_blank"> 搜狐</a></td>
		 				<td><a href="http://www.qq.com" target="_blank"> 腾讯</a></td>
		 				<td><a href="http://www.sohu.com/" target="_blank"> 搜狐</a></td>
		 				<td><a href="http://www.sohu.com/" target="_blank"> 搜狐</a></td>
		 			</tr>
		 		</tbody>
		 	</table>
		</div>
	</div>
	</div>