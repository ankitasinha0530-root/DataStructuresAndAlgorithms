package com.dsalgos.practice.recurssion;

public class QPrintSubSequence {

	public static void main(String[] args) {
			
		printSubsequence("abc", "");

	}

	private static void printSubsequence(String str, String ans) {
			
		if(str.length() == 0) {
			System.out.print(ans + ", ");
			return;
		}
		
		char ch = str.charAt(0);
		String roq = str.substring(1);
		
		printSubsequence(roq, ans + "");
		printSubsequence(roq, ans + ch);
		
	}

}
