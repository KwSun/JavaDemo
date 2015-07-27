package com.test.util;

import java.io.IOException;  

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;
public class CharacterEncodingFilter  implements Filter {
    public void destroy(){   
    }   
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException  
    {   
    	 request.setCharacterEncoding("utf-8");  
        //request.setCharacterEncoding("gb2312"); 
        // request.setCharacterEncoding("gbk"); 
    	//request.setCharacterEncoding("ISO-8859-1"); 
     chain.doFilter(request, response);  
    }   
    //@Override 
    public void init(FilterConfig arg0) throws ServletException {  
    }  

}


