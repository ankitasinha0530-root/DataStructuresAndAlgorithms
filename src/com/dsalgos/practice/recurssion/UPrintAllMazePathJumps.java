package com.dsalgos.practice.recurssion;

public class UPrintAllMazePathJumps {

	public static void main(String[] args) {

		int sRow = 1;
		int sCol = 1;
		int dRow = 3;
		int dCol = 3;
		printAllMazePathJumps(sRow, sCol, dRow, dCol, "");
		System.out.println();
		printAllMazePathJumpsV2(sRow, sCol, dRow, dCol, "");
		System.out.println();
	//	getAllMazePathV2(sRow, sCol, dRow, dCol, "");
	}

	private static void printAllMazePathJumps(int sRow, int sCol, int dRow, int dCol, String ans) {

		if (sRow == dRow && sCol == dCol) {
			System.out.println(ans);
			return;
		}
		for (int i = 1; i <= dRow; i++) {

			if (sCol < dCol) {
				printAllMazePathJumps(sRow, sCol + i, dRow, dCol, ans + 'H'+i);
			}
			if (sRow < dRow) {
				printAllMazePathJumps(sRow + i, sCol, dRow, dCol, ans + 'V'+i);
			}
			if (sCol < dCol && sRow < dRow) {
				printAllMazePathJumps(sRow + i, sCol + i, dRow, dCol, ans+'D'+i);
			}
		}
	}

	private static void printAllMazePathJumpsV2(int sRow, int sCol, int dRow, int dCol, String ans) {
		
		if (sRow == dRow && sCol == dCol) {
			System.out.println(ans);
			return;
		}
		
		for (int i = 1; i <= dCol - sCol; i++) {
			printAllMazePathJumpsV2(sRow, sCol + i, dRow, dCol, ans + 'H'+i);
		}
		for (int i = 1; i <= dRow - sRow; i++) { 
			printAllMazePathJumpsV2(sRow + i, sCol, dRow, dCol, ans + 'V'+i);
		}
		for (int i = 1; i <= dRow - sRow && i <= dCol - sCol	; i++) {
			printAllMazePathJumpsV2(sRow + i, sCol + i, dRow, dCol, ans + 'D'+i);
		}
			
	}

}
