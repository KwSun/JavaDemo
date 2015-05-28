package org.duohuo.singleton;

public class Person4 {
	//懒汉式,多线程不可以保证
	private String name;
	private static Person4 person;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//构造函数私有化
	private Person4(){
		
	}
	
	//提供一个全局静态方法，使用同步方法
	//双重检查
	public static synchronized Person4 getPerson(){
		if(person==null){
			synchronized (Person4.class) {
				if(person == null){
				person =  new Person4();
				}
			}
		}
		return person;
	}
}
