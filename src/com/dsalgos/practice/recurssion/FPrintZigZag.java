package com.dsalgos.practice.recurssion;

public class FPrintZigZag {

	public static void main(String[] args) {

		printZigZag(2);
		System.out.println();
		printZigZag(3);
		
	}

	private static void printZigZag(int n) {

		if(n==0) {
			return;
		}
		System.out.println("Pre = " + n);
		printZigZag(n-1);
		System.out.println("In = " + n);
		printZigZag(n-1);
		System.out.println("Post = " + n);
	}

	
}
