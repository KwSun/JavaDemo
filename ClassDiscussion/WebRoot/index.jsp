<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.test.util.DateAndTime"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${student.sname }的个人主页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">
var sno;
var state;
var xmlHttp;
function submitPost()
{
	
	sno = document.getElementById("sno").value;
	
	state = document.getElementById("state").value;
	
	createRequest('modifystatus.jsp'+'?sno='+sno+'&state='+encodeURI(state));
	
}
function checkForm()
{
	if(state =="")
	{
		alert("状态信息不能为空!");
		return false;
    }
}

 var http_request=false;
function createRequest(url)
{
    http_request = false;
   if (window.XMLHttpRequest) { // Mozilla, Safari,...
      http_request = new XMLHttpRequest();
      if (http_request.overrideMimeType) {
         http_request.overrideMimeType('text/html');
      }
   } else if (window.ActiveXObject) { // IE
      try {
         http_request = new ActiveXObject("Msxml2.XMLHTTP");
      } catch (e) {
         try {
            http_request = new ActiveXObject("Microsoft.XMLHTTP");
         } catch (e) {}
      }
   }
   if (!http_request) {
      alert('不能创建XMLHTTP实例!');
      return false;
   }
   http_request.onreadystatechange=alertContents;
   http_request.open("POST",url,true);
   http_request.send(null);
}
function alertContents()
{
  if(http_request.readyState==4)
  {
    if(http_request.status==200)
    {
      alert('状态更新成功');
     // alert(http_request.responseText);
    }else
    {
      alert('您请求的页面发生错误');
    }
  }
  
}
</script>

</head>
<body>
	<%@include file="head.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-body">
					   <p class="text-left">姓名：${student.sname }</p>
					   <form action="" class="form-inline text-left">
					           	<div class="from-group">
					           		<input type="hidden" name="sno" id="sno" class="form-control" value="${student.sno }"/>
					           		<label for="state">状态：</label>
					   				<input type="text" name="state" class="form-control" id="state" value="${student.status }"/>
					   				<input ype="button" onclick="submitPost()" class="btn btn-success" value="更改状态" />
					           	</div>
					   </form>
					</div>
				</div>
				<div class="clearfix">
					<div class="col-md-6">
						<div class="panel panel-primary">
							  <div class="panel-heading">
									<h3 class="panel-title">学院通知</h3>
							  </div>
							  <div class="panel-body">
									<ul>
										<s:iterator value="#request.acaInfoList" id="id" status="st">
											<s:url id="url2" action="showInfo">
												<s:param name="infoid" value="#id.Id"></s:param>
											</s:url>

											<li><a href="<s:property value="#url2"/>"> <s:property
														value="#id.title" /> <s:property value="#id.pubdate" />
											</a></li>
										</s:iterator>
									</ul>
							  </div>
							<div class="panel-footer clearfix">
								<a href="showinfolist.action?typeid=1" class="pull-right">更多</a>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel panel-primary">
							  <div class="panel-heading">
									<h3 class="panel-title">班级通知</h3>
							  </div>
							  <div class="panel-body">
									<ul>
										<s:iterator value="#request.claInfoList" id="id" status="st">
											<s:url id="url2" action="showInfo">
												<s:param name="infoid" value="#id.Id"></s:param>
											</s:url>

											<li><a href="<s:property value="#url2"/>"> <s:property
														value="#id.title" /> <s:property value="#id.pubdate" />
											</a></li>
										</s:iterator>
									</ul>
							  </div>
							<div class="panel-footer clearfix">
								<a href="showinfolist.action?typeid=2" class="pull-right">更多</a>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default" >
					<div class="panel-body">
					   <!-- 循环读入好友动态
					   <!-- 一个好友的动态开始 -->
					   <s:iterator value="#request.statusList" id="id" status="st">
					   	<div class="frupcontent">
					   		<s:url id="url2" action="showInfo">
					   			<s:param name="infoid" value="#id.Id"></s:param>
					   		</s:url>
					   		<div class="frhead">
					   			<!--用户头像-->
					   			<s:if test="#id.image!=null">
					   				<a
					   					href='showStudentInfo.action?sno=<s:property value="#id.sno"/>'>
					   					<img src='UploadImages/<s:property value="#id.image"/>'
					   					width=70 height=70 border=0 /> </a>
					   			</s:if>
					   		</div>
					   		<div class="frtext">
					   			<a
					   				href='showStudentInfo.action?sno=<s:property value="#id.sno"/>'>
					   				<s:property value="#id.sname" />: <s:property
					   					value="#id.status" /> </a> <br> 更新于
					   			<s:property value="#id.uptime" />

					   		</div>
					   	</div>
					   </s:iterator>
					   <!-- 一个好友的动态结束 -->
					   <!-- 循环结束 -->
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
					   <marquee behavior="scroll" direction="left" scrollamount="2">
					   <s:iterator value="#request.photoList" id="id" status="st">
					   	<s:url id="url2" action="showInfo">
					   	</s:url>
					   </s:iterator> </marquee>
					</div>
				</div>
			</div>
			<%@include file="asideSay.jsp" %>
		</div>
	</div>
</body>
</html>
