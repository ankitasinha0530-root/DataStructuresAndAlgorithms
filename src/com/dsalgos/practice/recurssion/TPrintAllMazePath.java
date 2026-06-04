package com.dsalgos.practice.recurssion;

public class TPrintAllMazePath {

	public static void main(String[] args) {

		int sRow = 1;
		int sCol = 1;
		int dRow = 3;
		int dCol = 3;
		getAllMazePath(sRow, sCol, dRow, dCol, "");
		System.out.println();
		getAllMazePathV2(sRow, sCol, dRow, dCol, "");
	}

	private static void getAllMazePath(int sRow, int sCol, int dRow, int dCol, String ans) {
		if (sRow == dRow && sCol == dCol) {
			System.out.println(ans);
			return;
		}
		if (sRow > dRow || sCol > dCol) {
			return;
		}

		getAllMazePath(sRow, sCol + 1, dRow, dCol, ans + 'H');
		getAllMazePath(sRow + 1, sCol, dRow, dCol, ans + 'V');

	}

	private static void getAllMazePathV2(int sRow, int sCol, int dRow, int dCol, String ans) {

		if (sRow == dRow && sCol == dCol) {
			System.out.println(ans);
			return;
		}
		if (sCol < dCol) {
			getAllMazePath(sRow, sCol + 1, dRow, dCol, ans + 'H');
		}
		if (sRow < dRow) {
			getAllMazePath(sRow + 1, sCol, dRow, dCol, ans + 'V');
		}

	}

}
