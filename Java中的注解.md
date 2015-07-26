title: Java中的注解
date: 2015-07-23 21:30:52
tags:
categories:
---
#Java中的注解
##注解的好处
 * 读懂他人代码，特别是框架相关的代码
 * 让编程简洁，代码清晰

##概念
 * Java提供的一种源程序中的元素关联人和信息和任何元数据的途径和方法

##Java中的常见注解
 * @Override: 限定重写父类方法, 该注解只能用于方法 * @Deprecated: 用于表示某个程序元素(类, 方法等)已过时 * @SuppressWarnings: 抑制编译器警告. 


##常见第三方注解
###Spring
 * @Autowired
 * @Service
 * @Repository

###Mybatis
 * @InsertProvider
 * @Updateprovider
 * @Options

##注解分类
###按照运行机制分
* 源码注解:注解只在源码中存在，编译成.class文件就不存在了
* 编译时注解:注解在源码和.class文件中都存在(@Override、@Deprecated、@SuppressWarnings)
* 运行时注解:在运行阶段还气作用，甚至会影响运行逻辑的注解(@Autowired等)

###按照来源分
* 来自JDK的注解
* 来自第三方的注解
* 自己定义的注解

###元注解
* 即注解的注解，给注解做注解

##自定义注解
###自定义注解的语法要求
	 package com.kw.annotation;
	 import java.lang.annotation.*;
	 /*
 	  * 1、使用@interface关键字定义注解
      * 2、成员以无参无异常方式声明
      * 3、可以用default为成员指定一个默认值
      * 4、成员类型是受限制的，合法的类型包括原始类型以及String,Class,Annotation,Enumeration
      * 5、如果注解只有一个成员,则成员必须取名为value(),在使用时可以忽略成员名和赋值号
      * 6、注解类可以没有成员，没有成员的注解称为标识注解
      */
	@Target({ElementType.METHOD,ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Inherited
	@Documented
	public @interface Description {
		String desc();
		String author();
		int age() default 18;
	}

###注解的注解（元注解）
	//注解的作用域,包括构造方法、字段、局部变量、方法、包、参数、类、接口
    @Target({ElementType.METHOD,ElementType.TYPE})
    //生命周期:源代码、编译时、运行时
	@Retention(RetentionPolicy.RUNTIME)
	//允许子类集成
	@Inherited
	//生成javadoc时包含注解信息
	@Documented

###使用自定义注解
	使用注解的语法：
		@<注解名>（<成员名1>=<成员名1>，<成员名2>=<成员名2>）
    @Description(desc="I am eyeColor",author="Duohuo boy",age=18)
	public String eyeColor(){
		return "red";
	}
###解析注解
* 概念：通过反射获取类、函数或成员上的运行时注解信息，从而实现动态控制程序运行的逻辑。

       
        public class Parse {
	     public static void main(String[] args) {
		//1、使用类加载器加载类
		 try {
			 Class c = Class.forName("org.duohuo.test.Child");
			 //2、找到类上面的注解
			 boolean isExist = c.isAnnotationPresent(Description.class);
			 if (isExist) {
				 //3、拿到注解实例
				 Description d = (Description) c.getAnnotation(Description.class);
				System.out.println(d.value());
			}
			//4、找到方法上的注解
			Method[] ms = c.getMethods();
			for(Method m:ms){
				boolean isMexist = m.isAnnotationPresent(Description.class);
				if (isMexist) {
					Description d = (Description) m.getAnnotation(Description.class);
					System.out.println(d.value());
				}
			}
			//另一种解析方法
			for(Method m:ms){
				Annotation[] as = m.getAnnotations();
				for(Annotation a:as){
					if(a instanceof Description){
						Description d = (Description) a;
						System.out.println(d.value());
					}
				 }
			  }
		  } catch (Exception e) {
			 // TODO: handle exception
		   }
	     }
        }

 
 