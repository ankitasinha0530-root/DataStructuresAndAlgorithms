package com.dsalgos.practice.recurssion;

public class DprintFactorial {

	public static void main(String[] args) {
		System.out.println(printFactorial(10));
		System.out.println(printFactorial(5));
	}

	private static int printFactorial(int n) {
		if(n==1) {
			return 1;
		}
		return printFactorial(n-1) * n; // multiple current n with previous number
	}
	
	private static int printFactorialV2(int n) {
		if(n==1) {
			return 1;
		}
		int factOfnm1 = printFactorialV2(n-1);
		int factOfn = n * factOfnm1;
		
		return factOfn; 
	}

}
