package com.dsalgos.practice.recurssion;

public class FPrintFibonnaciSeries {

	public static void main(String[] args) {
		// Fibonacci Series of 10 numbers: 0 1 1 2 3 5 8 13 21 34 
		int maxNumber = 10;
		System.out.print("Fibonacci Series of " + maxNumber + " numbers: ");
		for (int i = 0; i < maxNumber; i++) {
			System.out.print(fibonacciRecursion(i) + " ");
		}
	}

	public static int fibonacciRecursion(int n) {
		
		if (n == 0) { // 0th element is 0 in the series
			return 0;
		}
		if (n == 1 || n == 2) { //as both 1st and 2nd element is 1
			return 1;
		}
		return fibonacciRecursion(n - 2) + fibonacciRecursion(n - 1);
	}

}
