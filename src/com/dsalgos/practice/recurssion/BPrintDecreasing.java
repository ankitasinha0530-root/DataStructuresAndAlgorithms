package com.dsalgos.practice.recurssion;

public class BPrintDecreasing {

	public static void main(String[] args) {

		printDecreasing(0);
		printDecreasingV2(10);
	}
	
	public static void printDecreasing(int n) { // when n = 0
		
		if(n==11) {
			return;
		}
		printDecreasing(n+1);
		System.out.println(n);
	}
	
	public static void printDecreasingV2(int n) { // when n = 10
		
		if(n==-1) {
			return;
		}
		System.out.println(n);
		printDecreasingV2(n-1);
	
	}
}
