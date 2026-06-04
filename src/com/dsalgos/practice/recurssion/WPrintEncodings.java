package com.dsalgos.practice.recurssion;

public class WPrintEncodings {

	public static void main(String[] args) {

		printEncodings("123", "");
	}

	private static void printEncodings(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans);
		} else if (str.length() == 1) {
			// check if the character is 0
			char ch = str.charAt(0);
			if (ch == '0') {
				return;
			} else {
				// if the character is not zero
				int valOfch = ch - '0';
				char codeOfch = (char) ('a' + valOfch - 1); // extract its corresponding alphabet
				System.out.println(ans + codeOfch); // add to answer and print the output
			}
		} else {
			// if the question string length is greater than 1
			char ch = str.charAt(0); // extract 1st character
			String roq = str.substring(1);
			if (ch == '0') { // if the character is 0 simply return
				return;
			} else {
				int valOfch = ch - '0'; // convert char to integer
				char codeOfch = (char) ('a' + valOfch - 1); // extract its corresponding alphabet
				printEncodings(roq, ans + codeOfch); // make recursive call by extracting only first element
			}
			String ch12 = str.substring(0, 2); // if we extract 2 elements
			String roq12 = str.substring(2);
			int valOfch12 = Integer.parseInt(ch12); // convert the string to integer

			if (valOfch12 <= 26) {
				char codeOfch12 = (char) ('a' + valOfch12 - 1); // extract the alphabet
				printEncodings(roq12, ans + codeOfch12); // add in answer and make recursive call
			}
		}

	}

}
