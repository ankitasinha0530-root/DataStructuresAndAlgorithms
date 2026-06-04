package com.dsalgos.practice.recurssion;

import java.util.ArrayList;
import java.util.List;

public class LFindAllOccurrenceOfK {

	public static void main(String[] args) {

		int[] arr = {1, 7, 10, 8, 9, 14, 12, 9, 18};
	
		System.out.println(findAllOccurrenceOfK(arr, 0, 9, new ArrayList<Integer>()));
		System.out.println();
		int[] result = findAllOccurrenceOfKV2(arr, 0, 9, 0);
		for(int i : result) {
			System.out.print(i + ", ");
		}
	}

	private static List<Integer> findAllOccurrenceOfK(int[] arr, int idx, int k, List<Integer> list) {

		if(idx == arr.length) {
			return list;
		}
		if(k == arr[idx]) {
			list.add(idx);
		}
		findAllOccurrenceOfK(arr, idx+1, k, list);
		return list;	
	}
	
	private static int[] findAllOccurrenceOfKV2(int[] arr, int idx, int k, int fsf) {

		if(idx == arr.length) {
			return new int[fsf];
		}
		
		if(k == arr[idx]) {
			int[] arr1 =	findAllOccurrenceOfKV2(arr, idx+1, k, fsf+1);
			arr1[fsf] = idx;
			return arr1;
		}else {
			int[] arr1 = findAllOccurrenceOfKV2(arr, idx+1, k, fsf);
			return arr1;	
		}
	}
}
