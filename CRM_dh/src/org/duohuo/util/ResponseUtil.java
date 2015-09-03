package org.duohuo.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年9月3日 下午8:20:38 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */

public class ResponseUtil {
	public static void write(HttpServletResponse response,Object o)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
}
