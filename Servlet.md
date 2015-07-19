#Servlet
###ServletRequest
 * 获取请求参数
 	
 	String getParameter(String name):根据请求参数的名字，返回参数值;若请求参数有多个值(checkbox),该方法只能获取到第一个提交的值
 	
 	String[] getParameterValues(String name):根据请求参数的名字，返回请求参数对应的字符串数组。 
 	
 	Enumeration getParameterNames():返回参数名对应的Enumeration对象，类似于ServletConfig(或ServletContext)的	getInitParameterNames
 	
 	Map getParameterMap():返回请求参数的键值对：key(参数名)+value(参数值，String数组类型)
 	
 * 获取请求的URL
   
   String requestURI = httpServletRequest.getRequestURI();
   
 * 获取请求方式
 
   String method = httpServletRequest.getMethod();
   
 * 获取请求额Servlet的映射路径

   String ServletPath = http ServletRequest.getServletPath();

