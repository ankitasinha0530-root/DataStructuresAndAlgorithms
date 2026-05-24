package com.dsalgos.practice.sorting.algorithms;

public class DQuickSortAlg {

	public static void main(String[] args) {
/**
		 Uses Partitioning logic best case time complexity O(nlogn) , worst O(n^2), space complexity O(n)
		 take a pivot element, for best Case Scenario
		 option 1 - take middle element as pivot
		 option 2 - take random element as a pivot
		 step 1 : take 2 pointers low = 0 and high = arr.length -1
		 step 2 : until arr[low] <= pivot keep on doing low ++ ,
		 			we are trying to move all the lower values than pivot to the left side
		 step 3 : until arr[high] > pivot keep on doing high --
					we are trying to move all the lower values than pivot to the left side
		 step 4 : if step 2 and step 3 are done, then swap the elements at low and high
		 step 5 : keep repeating step 2, 3 and 4 only till low < high
		 step 6 : as soon low > high then swap the pivot element with high
		 after step 6 pivot element will be at its sorted position
		 recursively call from step 1 to 5 for elements before pivot current position
		 and second recursive call for element after the pivot current position
 */

		int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
		quickSort(arr, 0, arr.length - 1);
		
		for(int el : arr) {
			System.out.print(el + ", ");
		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		
		if(low < high) {
			int pivotPos = partitioningLogic(arr, low, high);
			quickSort(arr, low, pivotPos - 1);
			quickSort(arr, pivotPos + 1, high);
		}
	}
//	{4, 6, 2, 5, 7, 9, 1, 3};

	private static int partitioningLogic(int[] arr, int low, int high) {
		
		int middle = (low + high)/2;
		int pivot = arr[middle];
		
		while(low < high) {

			while(arr[low] <= pivot) {low++;}
			while(arr[high] > pivot) {high--;}
			if(low < high) {
				swap(arr, low, high);
			}
		}
		swap(arr, high, middle);
		
		return high;
	}

	private static void swap(int[] arr, int low, int high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
		
	}

}
