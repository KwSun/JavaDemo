package cn.microvideo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@RequestMapping("/home.action")
	public String goHome(HttpServletRequest request){
		System.out.println(request.getRequestURI());
		return "index";
	}
}
