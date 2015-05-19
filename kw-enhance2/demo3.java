package org.duohuo.enhance2;

import java.lang.reflect.Constructor;

public class demo3 {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("org.duohuo.enhance2.User");
		Constructor[] cons= clazz.getDeclaredConstructors();
//		System.out.println(cons.length);
		//获取带参数的私有的构造函数对象
		Constructor con = clazz.getDeclaredConstructor(int.class,int.class);
		System.out.println(con);
		//用反射私有的构造函数创建对象
		con.setAccessible(true);
		User myuser = (User) con.newInstance(12,13);
//		System.out.println(myuser.getAge()+","+myuser.weight);
		//获取suoy0ou的公有的构造函数
		cons = clazz.getConstructors();
		System.out.println(cons.length);
		
		con = clazz.getConstructor(int.class);
		System.out.println(con);
		
		 User myuser2 = (User) con.newInstance(100);
		 System.out.println(myuser2);
		 System.out.println(myuser2.getAge());
		
	}
	
}
