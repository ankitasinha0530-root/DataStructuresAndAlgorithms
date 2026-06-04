package com.dsalgos.practice.recurssion;

import java.util.ArrayList;
import java.util.List;

public class NGetWordsfromKeypadCodes {
	
	static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

	public static void main(String[] args) {

		String str = "678";
		System.out.println(getWordsfromKeypadCodes(str));
	}

	private static List<String> getWordsfromKeypadCodes(String str) {

		if(str.length() == 0) {
			List<String> bres= new ArrayList<>();
			bres.add("");
			return bres;
		}
		
		char ch = str.charAt(0);
		String roq = str.substring(1);
		List<String> tempList = getWordsfromKeypadCodes(roq);
		
		List<String> resultList = new ArrayList<>();
		
		String code = codes[ch - '0'];    // since ch is char so to make it numeral " - '0' "
		
		for(int i = 0; i < code.length(); i++) {
			char chr = code.charAt(i);
			for (String temp : tempList) {
				resultList.add(chr + temp);
			}
		}
		return resultList;
	}
}
