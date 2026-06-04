package com.dsalgos.practice.recurssion;

public class IDisplayArrInReverse {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 5, 7, 8, 9, 10, 12};
		
		displayArray(arr, 0);
	}

	private static void displayArray(int[] arr, int idx) {

		if(idx == arr.length) {
			return;
		}
		
		displayArray( arr, idx+1);  
		System.out.println(arr[idx]);  // Post when printing in reverse
		
	}
}
