package com.dsalgos.practice.recurssion;

public class RPrintKeyPadCombination {

	static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

	public static void main(String[] args) {

		String str = "678";
		printWordsfromKeypadCodes(str, "");
	}

	private static void printWordsfromKeypadCodes(String str, String ans) {

		if(str.length() == 0) {
			System.out.println(ans + ", ");
			return;
		}
			char ch = str.charAt(0);
			String roq = str.substring(1);
			
			String code = codes[ch - '0'];
			
			for (int j = 0; j < code.length(); j++) {
				printWordsfromKeypadCodes(roq, ans+code.charAt(j));
			}
		
	}

}
