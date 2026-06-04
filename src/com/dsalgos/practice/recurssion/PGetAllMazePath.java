package com.dsalgos.practice.recurssion;

import java.util.ArrayList;
import java.util.List;

public class PGetAllMazePath {

	public static void main(String[] args) {


		int sRow = 1;
		int sCol = 1;
		int dRow = 3;
		int dCol = 3;
		System.out.println(getAllMazePath(sRow, sCol, dRow, dCol));
		System.out.println(getAllMazePathV2(sRow, sCol, dRow, dCol));
	}

	private static List<String> getAllMazePath(int sRow, int sCol, int dRow, int dCol) {

		if(sRow == dRow && sCol == dCol) {
			List<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}
		if(sRow > dRow || sCol > dCol) {
			List<String> bres = new ArrayList<>();
			return bres;
		}
		
		List<String> hMove = getAllMazePath(sRow, sCol+1, dRow, dCol);
		List<String> vMove = getAllMazePath(sRow+1, sCol, dRow, dCol);
		
		List<String> resList = new ArrayList<>();
		for(String st : hMove) {
			resList.add('h' + st);
		}
		for(String st : vMove) {
			resList.add('v' + st);
		}
		
		return resList;
	}

	private static List<String> getAllMazePathV2(int sRow, int sCol, int dRow, int dCol) {

		if(sRow == dRow && sCol == dCol) {
			List<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}
		
		List<String> hMove = new ArrayList<>();
		List<String> vMove = new ArrayList<>();
		
		if(sRow < dRow){
			hMove = getAllMazePath(sRow, sCol+1, dRow, dCol);
		}
		if(sCol < dCol) {
			vMove = getAllMazePath(sRow+1, sCol, dRow, dCol);
		}
		
		List<String> resList = new ArrayList<>();
		for(String st : hMove) {
			resList.add('h' + st);
		}
		for(String st : vMove) {
			resList.add('v' + st);
		}
		
		return resList;
	}


}
