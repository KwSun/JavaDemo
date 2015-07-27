<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <base href="<%=basePath%>">

   <title>My JSP 'upload.jsp' starting page</title>

   <meta http-equiv="pragma" content="no-cache">
   <meta http-equiv="cache-control" content="no-cache">
   <meta http-equiv="expires" content="0">
   <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
   <meta http-equiv="description" content="This is my page">
   <!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<script type="text/javascript"> 
function addMore(){ 
var td=document.getElementById("more"); 
var br=document.createElement("br"); 
var input=document.createElement("input"); 

var input2=document.createElement("input");
var input3=document.createElement("input");

var button=document.createElement("input");

input.type="file"; 
input.name="file";

input2.type="text"; 
input2.name="phototitle";

input3.type="text"; 
input3.name="photodescribe";

button.type="button"; 
button.value="删除";

button.onclick=function(){ 
td.removeChild(br); 
td.removeChild(input); 
td.removeChild(input2); 
td.removeChild(input3); 
td.removeChild(button); 
} 

td.appendChild(br); 
td.appendChild(input); 
td.appendChild(input2);
td.appendChild(input3);
td.appendChild(button); 
} 
</script>

<link href="css/back.css" rel="stylesheet" type="text/css">
</head>

<body>
<div style="font-size:12px; margin:15px; text-align:left" align="left">
<s:fielderror cssStyle="color:#CC4411;"/>

   <s:form action="uploadPhoto.action" method="post" enctype="multipart/form-data">
    <table align="center" width="60%" border="1">
     <tr>
      <td>
       选择上传的文件:
      </td>
      <td id="more">
       <%--<s:file name="file" label="选择上传的文件"></s:file>--%>
       <input type="file" name="file">
       标题<input type="text" name="phototitle">
       描述<input type="text" name="photodescribe">
       <input type="button" value="继续添加" onClick="addMore()" />
      </td>
     </tr>
     <tr>
      <td>
      </td>
      <td align="right">
       <s:submit value="开始上传"></s:submit>
      </td>
     </tr>
    </table>
   </s:form>
</div>
</body>
</html>

