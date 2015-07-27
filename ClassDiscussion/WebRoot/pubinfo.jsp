<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Web</title>
<link href="css/back.css" rel="stylesheet" type="text/css" />
</head>

<body bgcolor="#F6F6F6">
<div style="margin:20px; text-align:left">
  <form action="adminAddInfo.action" method="post">
  Title<input type="text" class="text" name="title"/><br><br>
 Type<select class="text" name="typeid">
       <option value="1" selected >College
       <option value="2">Class
       </option>   
       </select>  <br><br>
Content<br />
    <textarea name="content" class="textarea"></textarea><br><br>
    <div style="float:left; width:280px"></div>
    <input type="submit" class="button" value="Submit">
  </form>
</div>
</body>

</html>
