package org.duohuo.singleton;

public class Person {
	//饿汉式，单、多线程都可以保证
	public static final Person person = new Person();
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//构造函数私有化
	private Person(){
		
	}
	
	//提供一个全局静态方法，使用同步方法
	public static Person getPerson(){
		return person;
	}
}
