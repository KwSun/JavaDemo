package cn.microvideo.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.glassfish.gmbal.ParameterNames;

import cn.microvideo.domain.Person;
import cn.microvideo.service.PersonService;

@Controller
public class PersonController {
	@Resource
	PersonService personService;
	
	//列表
	@RequestMapping("/person/listAll.action")
	public String listAll(Map<String,Object> model){
		List<Person> personList = personService.listAll();
		//将返回的list集合在页面中调用
		model.put("personList", personList);
		return "person/jPersonList";
	}
	
	//转向新增页面
	@RequestMapping("/person/tocreate.action")
	public String tocreate(){
		return "person/jPersonCreate";
	}
	
	//新增保存，返回列表
	
		//从页面上获取参数，需要哪个参数，声明哪个参数，它会自动转类型
		/*
		 * 现今流行开发范式，约定，在开发时，定了很多规矩；
		 * springmvc 通过页面提交request，request当中获取getParamter方法获得页面中的用户输入的内容。
		 * 它通过遍历request中获得的这些参数，找转入的方法中有没有匹配的setXxx方法，例如页面中有一个name
		 * 找方法setName，将用户填写的内容设置进去，同时，springmvc能得到参数的类型，进行强转。
		 */
		@RequestMapping("/person/insert.action")
		public String insert(Person p){
			personService.insert(p);
			
			return "redirect:/person/listAll.action";
		}
		
		//转向修改页面
		@RequestMapping("/person/toupdate.action")
		public String toupdate(Integer id,Model model){
			Person p = personService.get(id);
			model.addAttribute("person", p);
			return "person/jPersonUpdate";
		}
		
		//修改保存
		@RequestMapping("/person/update.action")
		public String update(Person p){
			personService.update(p);
			return "redirect:/person/listAll.action";
		}
		
		//删除一条
		@RequestMapping("/person/deleteById.action")
		public String deleteById(Integer id){
			personService.deleteById(id);
			return "redirect:/person/listAll.action";
		}
		
		//批量删除
		@RequestMapping("/person/delete.action")
		public String delete(@RequestParam("id")Integer[] ids){
			personService.delete(ids);
			return "redirect:/person/listAll.action";
		}
	
}
