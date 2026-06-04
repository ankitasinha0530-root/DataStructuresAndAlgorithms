package com.dsalgos.practice.recurssion;

public class HDisplayAnArrayusingRecursion {

	public static void main(String[] args) {
		
		int[] arr = {1, 5, 7, 8, 9, 10, 12};
		
		displayArray(arr, 0);
	}

	private static void displayArray(int[] arr, int idx) {

		if(idx == arr.length) {
			return;
		}
		
		System.out.println(arr[idx]);  // Pre when insertion order is maintained
		displayArray( arr, idx+1);
		
	}
}
 