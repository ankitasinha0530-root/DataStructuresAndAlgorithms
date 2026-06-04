package com.dsalgos.practice.recurssion;

public class FibonnaciSeriesNthElement {

	public static void main(String[] args) {

		System.out.println(fibonacciNthElement(6));
	}

	public static int fibonacciNthElement(int n) {

		if (n <= 1) {
			return n;
		}
		return fibonacciNthElement(n - 1) + fibonacciNthElement(n - 2);  // to find nth element in a fibonacci series
	}

}
