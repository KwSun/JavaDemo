package org.duohuo.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
//	String desc();
//	String author();
//	int age() default 18;
	String value();
}
