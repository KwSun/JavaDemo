package cn.microvideo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.microvideo.domain.Person;

/**
 * @Description: 
 * @Author:		
 * @Company:	
 * @CreateDate:	
 */
@Service
public class PersonService {
	/*
	 * 模拟10条人员信息
	 */
	private static Map<Integer,Person> personMap = new HashMap<Integer,Person>();
	private static Integer id = 0;
	static{
		for(int i=0;i<10;i++){
			Person p = new Person();
			p.setId(id++);
			p.setName("tony"+i);
			p.setAge(20+i);
//			p.setJoinDate(new Date());
			
			personMap.put(i, p);
		}
	}
	
	//获取所有记录
	public List<Person> listAll(){
		return new ArrayList(personMap.values());	//将map集合放到ArrayList
	}
	
	//查询一条
	public Person get(Integer id){
		return personMap.get(id);
	}
	
	//新增
	public void insert(Person p){
		p.setId(id++);		//设置id自增
		personMap.put(p.getId(), p);
	}
	
	//修改
	public void update(Person p){
		personMap.put(p.getId(), p);
	}
	
	//删除一条
	public void deleteById(Integer id){
		personMap.remove(id);
	}
	
	//批量删除
	public void delete(Integer[] ids){
		for(Integer id : ids){
			personMap.remove(id);
		}
	}
	
}
