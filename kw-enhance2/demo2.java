package org.duohuo.enhance2;

import java.lang.reflect.Method;

/**
 * 反射方法
 * @author apple
 *
 */
public class demo2 {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("org.duohuo.enhance2.User");
		Method[] meths = clazz.getMethods();
		System.out.println(meths.length); //12，因为继承了object的方法
		//获取所有的声明的方法
		meths = clazz.getDeclaredMethods();
		System.out.println(meths.length);
		
		//获取私有的带参数的方法
		Method sayHello = clazz.getDeclaredMethod("sayHello", String.class);
		System.out.println(sayHello);
		//调用私有的方法
		sayHello.setAccessible(true);
		sayHello.invoke(new User(), "kw");
		
		Method greet = clazz.getDeclaredMethod("greet", String.class);
		System.out.println(greet);
		greet.invoke(new User(), "kw");
		
	}
	
}
