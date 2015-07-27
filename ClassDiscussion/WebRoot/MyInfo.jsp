<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.test.util.DateAndTime" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人信息</title>
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
        <div class="panel panel-default">
          <div class="panel-body">
             <div class="clearfix" style="margin-left:127px;margin-bottom:30px;">
               <div class="pull-left">
                 <p><img src="UploadImages/${student.image}" alt="" class="img-rounded" /></p>
                 <a href="uploadImage.jsp" class="btn btn-primary">更换头像</a>
               </div>
             </div>
             <form action="modifyinfo.action" method="post" class="form-horizontal clearfix" role="form">
                <input type="hidden" name="sno" value="${student.sno }"/>
                <div class="form-group">
                  <label for="name" class="col-sm-2 control-label">姓名</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="sname" value="${student.sname }">
                  </div>
                </div>
                <div class="form-group">
                  <label for="age" class="col-sm-2 control-label">年龄</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="age" name="sname" value="${student.age }">
                  </div>
                </div>
                  <div class="form-group ">
                  <label class="col-sm-2 control-label">性别</label>
                  <div class="col-sm-10 clearfix">
                    <div class="pull-left">
                      <label for="v1" class="radio-inline">
                      <input type="radio" name="sex" value="1" id="v1"
                      <s:if test="#session.student.sex==1">
                        checked
                      </s:if>
                       >
                       男</label>
                      <label for="v2" class="radio-inline">
                      <input type="radio" name="sex" value="0" id="v2"
                      <s:if test="#session.student.sex==0">
                        checked
                      </s:if>
                      >
                      女</label>
                    </div>
                  </div>
                  </div>
                  <div class="form-group">
                    <label for="qq" class="col-sm-2 control-label">QQ</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="qq" name="qq"  value="${student.qq }">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="msn" class="col-sm-2 control-label">MSN</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="msn" name="msn"  value="${student.msn }">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">电话</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="phone" name="phone"  value="${student.phone }">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="domitory" class="col-sm-2 control-label">宿舍</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="domitory" name="domitory"  value="">
                    </div>
                  </div>
                  <div class="form-group ">
                  <label class="col-sm-2 control-label">修改密码</label>
                  <div class="col-sm-10 clearfix">
                    <div class="pull-left">
                      <label for="v3" class="radio-inline"><input type="radio" name="changepwd" value="0" id="v3" checked/>否</label>
                      <label for="v4" class="radio-inline"><input type="radio" name="changepwd" value="1" id="v4"/>是</label>
                    </div>
                  </div>
                  </div>
                  <div class="form-group">
                    <label for="pwd" class="col-sm-2 control-label">旧密码：</label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="pwd" name="pwd"  value="">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="newpwd" class="col-sm-2 control-label">新密码：</label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="newpwd" name="newpwd"  value="">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="renewpwd" class="col-sm-2 control-label">确认密码：</label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="renewpwd" name="renewpwd"  value="">
                    </div>
                  </div>
                 <div class="form-group">
                   <div class="col-sm-10 col-sm-offset-2">
                     <button type="submit" class="btn btn-primary">更改个人信息</button>
                   </div>
                 </div>
             </form>
          </div>
        </div>
      </div>
      <%@include file="aside.jsp" %>
    </div>
  </div>
</body>
</html>
