package org.duohuo.singleton;

public class Person2 {
	//懒汉式,多线程不可以保证
	private String name;
	private static Person2 person;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//构造函数私有化
	private Person2(){
		
	}
	
	//提供一个全局静态方法
	public static Person2 getPerson(){
		if(person==null){
		person =  new Person2();
		}
		return person;
	}
}
