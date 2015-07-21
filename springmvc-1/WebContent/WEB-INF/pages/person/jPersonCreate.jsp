<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
<form action="${pageContext.request.contextPath}/person/insert.action" method="post">
  
    新增人员信息 <br>
    
<table>
<tr>
	<td>姓名</td>
	<td><input type="text" name="name"/></td>
</tr>
<tr>
	<td>年龄</td>
	<td><input type="text" name="age"/></td>
</tr>

<tr>
	<td><input type="submit" name="btnSubmit" value="保存"/></td>
	<td></td>
</tr>
</table>    

</form>    
  </body>
</html>