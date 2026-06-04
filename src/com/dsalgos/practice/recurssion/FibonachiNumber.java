package com.dsalgos.practice.recurssion;

public class FibonachiNumber {

	// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
	public static void main(String[] args) {
		
		int n= 5;

		System.out.println(fibonachi(9));

	}

	private static int fibonachi(int n) {

//		if(n==0) return 0;
//		if(n==1) return 1;
		
		if(n < 2) return n;
		
		return fibonachi(n-1) + fibonachi(n-2);
	
		
	}

}
