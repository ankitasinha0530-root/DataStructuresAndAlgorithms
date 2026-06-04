package com.dsalgos.practice.recurssion;

import java.util.ArrayList;
import java.util.List;

public class SPrintGetStairPath {

	public static void main(String[] args) {
		
		System.out.println(getStairPath(3));
		System.out.println(getStairPath(5));
	}

	private static List<String> getStairPath(int n) {
		if(n == 0) {
			List<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}else if(n < 0) {  // since it is in negative so not the correct way to reach to 0th stairs
			List<String> bres = new ArrayList<>();
			return bres;
		}
		
		List<String> pathM1 = getStairPath(n-1);
		List<String> pathM2 = getStairPath(n-2);
		List<String> pathM3 = getStairPath(n-3);
		
		List<String> resList = new ArrayList<>();
		for(String st : pathM1) {
			resList.add(1 + st);
		}
		for(String st : pathM2) {
			resList.add(2 + st);
		}
		for(String st : pathM3) {
			resList.add(3 + st);
		}
		
		return resList;
	}

}
