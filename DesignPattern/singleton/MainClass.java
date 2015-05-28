package org.duohuo.singleton;

public class MainClass {
	public static void main(String[] args) {
//		Person per =Person.getPerson();
//		Person per2 =Person.getPerson();
		Person2 per =Person2.getPerson();
		Person2 per2 =Person2.getPerson();
		per.setName("zhangsan");
		per2.setName("lisi");
		
		System.out.println(per.getName());
		System.out.println(per2.getName());
	}

}
