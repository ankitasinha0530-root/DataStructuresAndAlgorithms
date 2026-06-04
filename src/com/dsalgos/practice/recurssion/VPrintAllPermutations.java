package com.dsalgos.practice.recurssion;

public class VPrintAllPermutations {

	public static void main(String[] args) {

		printAllPermutations("abc", "");

	}

	private static void printAllPermutations(String str, String ans) {

		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String loq = str.substring(0, i);  //we want elements left from i
			String roq = str.substring(i + 1); //we want elements right from i
			String remaining = loq+roq;
			printAllPermutations(remaining, ans+ch);
		}
	}

}
