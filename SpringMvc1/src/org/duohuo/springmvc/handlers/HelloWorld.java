package org.duohuo.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	/**
	 * 使用@RequestMapping注解来映射请求的URL
	 * 返回值会通过师徒解析器解析成实际的物理视图，会做如下的解析
	 * prefix+returnVal+suffix
	 * @return
	 */
	@RequestMapping("/helloworld")
	public String hello(){
		System.out.println("hello kw~");
		return "success";
	}
}
