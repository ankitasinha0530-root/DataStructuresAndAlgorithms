package com.dsalgos.practice.sorting.algorithms;

public class EMergeSortAlg2 {

	public static void main(String[] args) {
		
		// divide the array into two halves
		// sort each half separately
		// merge the two sorted halves

		int[] arr = {9, 4, 7, 5, 6, 3, 1, 5};
		mergeSort(arr, 0, arr.length - 1);
		
		for(int el : arr) {
			System.out.print(el + ", ");
		}
		System.out.println();
		int[] nums = {2,0,2,1,1,0};
		mergeSort(nums, 0, nums.length - 1);
		
		for(int el : nums) {
			System.out.print(el + ", ");
		}
	}

	private static void mergeSort(int[] arr, int low, int high) {

		if (low >= high) { // base Condition
			return;
		}

		int middle = (low + high)/2;
		mergeSort(arr, low, middle);
		mergeSort(arr, middle+1, high);
		mergeTwoParts(arr, low, middle, high);
	}

	   
	private static void mergeTwoParts(int[] arr, int low, int mid, int high) {
		int[] b = new int[arr.length];
		int k = low; // this is imortant
		int i = low; // this is important
		int j = mid+1;
		
		while(i <= mid && j <= high) {
			if(arr[i] < arr[j]) {
				b[k++] = arr[i++];
			}else {
				b[k++] = arr[j++];
			}
		}
		if(i > mid) {
			while(j <= high) {
				b[k++] = arr[j++];
			}
		}else {
			while(i <= mid) {
				b[k++] = arr[i++];
			}
		}
		for(k = low; k <= high; k++) {
			arr[k] = b[k];
		}
	}
		
}
