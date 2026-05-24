package com.dsalgos.practice.sorting.algorithms;

public class CSelectionSort {

	public static void main(String[] args) {

		// split the elements in two parts unsorted and sorted
		// in 1st iteration only 1st element will be in sorted array and starting from 2nd element its unsorted array
		// select minm element from unsorted array and put it in sorted array
		
		int[] arr = {4, 1, 9, 2, 3, 6};
		selectionSort(arr);
		for(int el : arr) {
			System.out.print(el + ", ");
		}
	}

	private static void selectionSort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) { // this loop will find the minm element from unsorted array
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			if(min != i) {
				swap(arr, min, i);
			}	
		}	
	}

	private static void swap(int[] arr, int min, int i) {
		int temp = arr[min];
		arr[min] = arr[i];
		arr[i] = temp;
	}

}
