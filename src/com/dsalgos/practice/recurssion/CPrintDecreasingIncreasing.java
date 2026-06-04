package com.dsalgos.practice.recurssion;

public class CPrintDecreasingIncreasing {
	
	public static void main(String[] args) {

		printDecreasingIncreasing(10);
	}
	
	public static void printDecreasingIncreasing(int n) { // when n = 10
		
		if(n==-1) {
			return;
		}
		System.out.println(n);    // Pre-Order Printing for Decreasing - 10, 9, 8, ...
		printDecreasingIncreasing(n-1);
		System.out.println(n);	// Post-Order Printing for Increasing - 0, 1, 2, ...
	
	}

}
