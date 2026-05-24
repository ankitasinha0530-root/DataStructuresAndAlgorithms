package com.dsalgos.practice.sorting.algorithms;

public class EMergeSortAlg {

	public static void main(String[] args) {
		
		// divide the array into two halves
		// sort each half separately
		// merge the two sorted halves

		int[] arr = {9, 4, 7,5, 6, 3, 1, 5};
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

//		if(arr.length < 1){
//			return;
//		}


		if(low < high) { // Always left < right to proceed with further splitting and recursion call
			int middle = (low + high)/2;
			mergeSort(arr, low, middle);
			mergeSort(arr, middle+1, high);
			mergeTwoParts(arr, low, middle, high);	
		}
	}
	   
	private static void mergeTwoParts(int[] arr, int low, int mid, int high) {
		int[] b = new int[arr.length];
		int k = low; // this is important for b array
		int i = low; // this is important
		int j = mid+1;
		
		while(i <= mid && j <= high) {
			if(arr[i] < arr[j]) {
				b[k] = arr[i];
				i++;
			}else {
				b[k] = arr[j];
				j++;
			}
			k++;
		}
		if(i > mid) {
			while(j <= high) {
				b[k] = arr[j];
				j++;
				k++;
			}
		}else {
			while(i <= mid) {
				b[k] = arr[i];
				i++;
				k++;
			}
		}
		for(k = low; k <= high; k++) {
			arr[k] = b[k];
		}
	}
		
}
/**

Steps :

1. first call mergeSort method with mergeSort(arr, left, right)
 2. in the method if arr.length < 1, then simply return
 3. Proceed to split only if left < right else skip
 4. if left < right, then find mid (left+right)/2
		call mergeSort(arr, left, mid)
 		and mergeSort(arr, mid+1, right)

 5. after both the calls call merge function ,merge(arr, left, right, mid)
 6. inside merge function create an intermediate array to sort and finally move from temparr to main array.

 ├── mergeSort(arr, 0,3)
 │
 │   ├── mergeSort(arr, 0,1)
 │   │
 │   │   ├── mergeSort(0,0) ← returns
 │   │   ├── mergeSort(1,1) ← returns
 │   │
 │   │   └── merge(0,1,0)  ← FIRST MERGE
 │   │
 │   └── mergeSort(arr, 2,3)
 │
 └── mergeSort(arr, 4,7)
 */
