package org.duohuo.enhance2;
/**
 * 反射的demo1,属性
 */
import java.lang.reflect.Field;

public class demo1 {
	public static void main(String[] args) throws Exception {
		//OptionMethod();
		//StaticMethod();
	}

	private static void StaticMethod() throws ClassNotFoundException,
			NoSuchFieldException, IllegalAccessException {
		Class clazz = Class.forName("org.duohuo.enhance2.User");
		Field field = clazz.getField("grade");
		System.out.println("设置之前的值"+field.get(null));
		field.set(null, 99);
		System.out.println("设置之后的值"+field.get(null));
	}

	private static void OptionMethod() throws ClassNotFoundException,
			NoSuchFieldException, IllegalAccessException {
		//获取user类class对象
		Class clazz = Class.forName("org.duohuo.enhance2.User");
		//获取所有的属性
		 Field[] fs = clazz.getDeclaredFields();
//		System.out.println(fs.length);
		//公有属性
		fs = clazz.getFields();
//		System.out.println(fs.length);
		User user = new User();
		//私有属性
		Field field = clazz.getDeclaredField("age");
//		System.out.println(field);
//		System.out.println(field.getName());
		field.setAccessible(true);
		System.out.println(field.get(user));
		//指定公有属性
		field = clazz.getField("weight");
//		System.out.println(field);
		
		System.out.println("设置之前的之前age的值："+field.get(user));
		field.set(user, 200);
		System.out.println("设置之前的之后age的值："+field.get(user));
	}
}
