package com.dsalgos.practice.recurssion;

public class OGetStairPath {

	public static void main(String[] args) {
		
		getStairPath(3, "");
		System.out.println();
		getStairPath(5, "");
	}

	private static void getStairPath(int n, String ans) {
		if(n == 0) {
			System.out.println(ans);
			return;
		}
		if(n < 0) {
			return;
		}
		
		getStairPath(n-1, ans + '1');
		getStairPath(n-2, ans + '2');
		getStairPath(n-3, ans + '3');
		
	}

}
