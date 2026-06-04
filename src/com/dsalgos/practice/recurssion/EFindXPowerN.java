package com.dsalgos.practice.recurssion;

public class EFindXPowerN {

	public static void main(String[] args) {

		System.out.println(findXPowerN(5, 3));
		System.out.println(findXPowerNV2(5, 3));
	}

	private static int findXPowerN(int x, int n) {

		if(n==0) {
			return 1;
		}
		return findXPowerN(x, n-1) * x;
	}
	
	private static int findXPowerNV2(int x, int n) {

		if(n==0) {
			return 1;
		}
		int fnMinus1 = findXPowerNV2(x, n-1);
		int fn = fnMinus1 * x;
		return fn;
	}

}
