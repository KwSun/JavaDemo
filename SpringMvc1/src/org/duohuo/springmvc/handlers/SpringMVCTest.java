package org.duohuo.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	private static final String SUCCESS = "success";
	
	/**
	 * @RequestParam来映射请求参数
	 * value 请求参数的参数名
	 * required 该参数是否必须，默认为true
	 * defaultValue 请求参数的默认值
	 * @param username
	 * @param age
	 * @return
	 */
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="username") String username,
			@RequestParam(value="age", required=false,defaultValue="0") int age){
		System.out.println("testRequestParam,username:"+username+",age:"+age);
		return SUCCESS;
	}
	
	/**
	 * 使用Method属性来制定请求方式
	 * @return
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("testMethod");
		return SUCCESS;
	}
	
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id){
		System.out.println("testPathVariable:"+id);
		return SUCCESS;
	}
	
}
