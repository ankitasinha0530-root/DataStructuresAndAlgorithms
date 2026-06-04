package com.dsalgos.practice.recurssion;

public class APrintIncreasing {
	
	public static void main(String[] args) {

		printIncreasing(0);
		printIncreasingV2(10);
	}
	
	public static void printIncreasing(int n) { // when n = 0
		
		if(n==11) {
			return;
		}
		System.out.println(n);  // Pre-Order Printing
		printIncreasing(n+1);

	}
	
	public static void printIncreasingV2(int n) { // when n = 10
		
		if(n==-1) {
			return;
		}

		printIncreasingV2(n-1);
		System.out.println(n);  // Post Order Printing
	
	}

}
