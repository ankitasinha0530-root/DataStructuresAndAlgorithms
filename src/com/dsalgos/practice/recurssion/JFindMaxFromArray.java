package com.dsalgos.practice.recurssion;

public class JFindMaxFromArray {

	public static void main(String[] args) {
		int[] arr = {1, 7, 10, 8, 9, 14, 12};

		System.out.println(findMaxFromAnArray(arr, 0));
		System.out.println(findMaxFromAnArrayV2(arr, 0));
	}

	private static int findMaxFromAnArray(int[] arr, int idx) {

		if(idx == arr.length) {
			return 0;
		}
		int maxOfSmallerArr = findMaxFromAnArray(arr, idx+1);
		return Math.max(maxOfSmallerArr, arr[idx]);
	}
	
	private static int findMaxFromAnArrayV2(int[] arr, int idx) {

		if(idx == arr.length) {
			return 0;
		}
		int maxOfSmallerArr = findMaxFromAnArrayV2(arr, idx+1);
		if(arr[idx] < maxOfSmallerArr) {
			return maxOfSmallerArr;
		}else {
			return arr[idx];
		}
	}

}
