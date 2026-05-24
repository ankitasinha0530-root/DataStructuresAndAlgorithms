package com.dsalgos.practice.sorting.algorithms;

public class ABubbleSort {

	public static void main(String[] args) {
		
		// step 1 : take i = 0 element and 2nd j + 1 element compare if i + 1 is small then swap with previous
		// step 2 : continue step until the end of the array
		// for j th element of inside loop, we take arr.length-i-1 because rightmost element will be at its right place after every pass
		// step 3 : for next i the iteration exclude the rightmost element as it is at its correct position
		// continue above steps until all elements are sorted, array from right side will start getting sorted
		// time complexity O(n^2)

		int[] arr = {4, 3, 7, 1, 5};
		
		bubbleSort(arr);
		for(int el : arr) {
			System.out.print(el + ", ");
		}
	}

	private static int[] bubbleSort(int[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			// optimization
			boolean swapped = false;   // if swapped even once in then inside loop this will become true,
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j+1] < arr[j]) {
					swapped = true;
					swap(arr, j , j+1);
				}
			}
			if(!swapped) {  // if this swapped remains false after completing the inner loop means the array is already sorted
				break; 		// since swapped is false, means array is already sorted, hence no more sorting , so break out of loop
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

}
