package com.dsalgos.practice.recurssion;

import java.util.ArrayList;
import java.util.List;

public class MFindAllSubsequence {

	public static void main(String[] args) {

		System.out.println(findSubstring("abc"));
	}

	private static List<String> findSubstring(String str) {
		// When length of string becomes zero return an empty list
		if(str.length() == 0) {
			List<String> mres = new ArrayList<>();
			mres.add("");
			return mres;  // return list with empty string
		}
		//abc
		char ch = str.charAt(0);  // extract 1 character 'a'
		String ros = str.substring(1);  // rest of the string "bc"
		List<String> templist = findSubstring(ros);  // perform above steps recursively
		
		// while coming down from the stack, create new ArrayList
		List<String> finalList = new ArrayList<>(); 
		
		for(String s : templist) {
			finalList.add("" + s);   // 1st add empty string to all the elements of the string
		}
		for(String s : templist) {
			finalList.add(ch + s);  // add 1st character extracted to to all the elements of the list
		}
		return finalList;
	}

}
