package com.dsalgos.practice.recurssion;

public class XPrintSetsToTargetSum {

	public static void main(String[] args) {

		int[] arr = {10, 20, 30, 40, 50, 60 };
		printSetsToTargetSum(arr, 0, "", 0, 60);
	}

	private static void printSetsToTargetSum(int[] arr, int idx, String set, int sum, int targetSum) {

		if(idx == arr.length) {
			if(targetSum == sum) {
				System.out.println(set);
				return;
			}
		}
			// 1st Case is that the element wants to be considered and added in set
			printSetsToTargetSum(arr, idx + 1, set + arr[idx] + ", ", sum + arr[idx], targetSum);
			
			// 1st Case is that the element does not wants to be considered and added in set
			printSetsToTargetSum(arr, idx + 1, set, sum, targetSum); 
		
		
		
	}

}
