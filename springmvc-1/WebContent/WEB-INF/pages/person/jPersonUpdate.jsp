<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
<sf:form action="${pageContext.request.contextPath}/person/update.action" 
	method="post" 
	modelAttribute="person"
	enctype="multipart/form-data"
	>
	<sf:hidden path="id"/>
  
    修改人员信息 <br>
    
<table>
<tr>
	<td>姓名</td>
	<td><sf:input path="name"/></td>
</tr>
<tr>
	<td>年龄</td>
	<td><sf:input path="age"/></td>
</tr>
<!-- <tr>
	<td>图片</td>
	<td><input type="file" name="uploadfile"/></td>
</tr> -->
<tr>
	<td><input type="submit" name="btnSubmit" value="保存"/></td>
	<td></td>
</tr>
</table>    

</sf:form>   
  </body>
</html>
