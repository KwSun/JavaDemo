package org.duohuo.enhance2;

public class User {
	private int age = 20;
	public int weight = 100;
	public static int grade = 100;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int age) {
		super();
		this.age = age;
	}

	private User(int age, int weight) {
		super();
		this.age = age;
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private void sayHello() {
		System.out.println("nihao");
	}

	private void sayHello(String name) {
		System.out.println("nihao" + name);
	}

	public void greet() {
		System.out.println("hello");
	}

	public void greet(String name) {
		System.out.println("hello" + name);
	}
}
