<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<script type="text/javascript">
		//通过js进行post提交
		function formSubmit(){
			document.forms[0].action = "${pageContext.request.contextPath}/person/delete.action";
			document.forms[0].submit();
		}
	</script>
  </head>
  
  <body>
 <form method="post"> 
  
    人员信息列表 <br>
    
    <div style="padding:10px;">
    	<a href="${pageContext.request.contextPath}/person/tocreate.action">新增</a>
    	<a href="#" onclick="formSubmit();">批量删除</a>
    </div>
    
<table border="1">
<tr>
	<td>序号</td>
	<td>选择</td>
	<td>姓名</td>
	<td>年龄</td>
	<!-- <td>入职日期</td> -->
	<td>操作</td>
</tr>

<c:forEach items="${personList}" var="p" varStatus="status">
<tr>
	<td>${status.index+1}</td>
	<td><input type="checkbox" name="id" value="${p.id}"></td>
	<td>${p.name}</td>
	<td>${p.age}</td>
	<%-- <td>${p.joinDate}</td> --%>
	<td>
		<a href="${pageContext.request.contextPath}/person/toupdate.action?id=${p.id}">修改</a>
		<a href="${pageContext.request.contextPath}/person/deleteById.action?id=${p.id}">删除</a>
	</td>
</tr>
</c:forEach>

</table>

</form>
  </body>
</html>