package org.duohuo.algorithm1;

import java.util.Scanner;
/**
 * 用递归求阶乘
 * @author apple
 *
 */
public class Recursion {
	public static long resursion(int n){
		if (n<=1) {
			return 1;
		} else {
			return n*resursion(n-1);
		}
	}
	public static void main(String[] args) {
		System.out.println("请输入要求阶乘的一个整数：");
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		System.out.println(i+"的阶乘结果是："+resursion(i));
	}
}
