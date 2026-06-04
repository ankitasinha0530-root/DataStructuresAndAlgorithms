package com.dsalgos.practice.recurssion;

public class KLasIdxOfOccurrence {

	public static void main(String[] args) {

		int[] arr = {1, 7, 10, 8, 9, 14, 12, 9, 18};

		System.out.println(firstIndexOfOccurrence(arr, 0, 9));
	//	System.out.println(firstIndexOfOccurrenceV2(arr, 0, 9));
//		System.out.println(firstIndexOfOccurrenceV2(arr, 1));

	}

	private static int firstIndexOfOccurrence(int[] arr, int idx, int k) {

		if(idx == arr.length) {
			return -1;
		}
		
		int lastIdxOfOccur = firstIndexOfOccurrence(arr, idx+1, k);
		
		if(lastIdxOfOccur == -1) {
			if(k == arr[idx]) {
				return idx;
			}else {
				return -1;
			}
		}else {
			return lastIdxOfOccur;           
		}
		
	}
	
//	private static int firstIndexOfOccurrenceV2(int[] arr, int idx, int k) {
//
//		if(idx == arr.length) {
//			return -1;
//		}
//		if(k == arr[idx]) {
//			return idx;
//		}else {
//			int fiisa = firstIndexOfOccurrence(arr, idx+1, k);
//			return fiisa;
//		}
//	}
}
