package com.dsalgos.practice.sorting.algorithms;

public class BInsertionSort {

	public static void main(String[] args) {
		// Assume 1part of array to be sorted and another part unsorted
		// step 2 : pick an element from unsorted and put it at its correct position inside sorted array
		// repeat step 2 : until all elements are sorted
		
		int[] arr = {8, 4, 1, 5, 9, 2};
		
		insertionSort(arr);
		for(int el : arr) {
			System.out.print(el + ", ");
		}

	}

	private static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while(j >= 0 && temp < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
		
	}

}
