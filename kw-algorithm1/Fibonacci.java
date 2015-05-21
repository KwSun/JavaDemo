package org.duohuo.algorithm1;

import java.util.Scanner;

public class Fibonacci {
	public static int Fibonacci(int n){
		int t1,t2;
		if (n==1|n==2) {
			return 1;
		} else {
			t1 = Fibonacci(n-1);
			t2 = Fibonacci(n-2);
			return t1+t2;
		}
		
	}
	public static void main(String[] args) {
		System.out.println("递推算法求解兔子产仔问题~");
		System.out.print("请输入时间：");
		Scanner input = new Scanner(System.in);
		//时间
		int n = input.nextInt();
		//求解
		int num = Fibonacci(n);
		System.out.println("经过"+n+"月的时间，共能繁衍出"+num+"对兔子");
	}
}

