package com.dsalgos.practice.recurssion;

public class ZAKnightsTourAllCells {

	public static void main(String[] args) {
		int n = 9;
		int row = 2;
		int col = 3;
		int[][] chess = new int[n][n];
		
		printKnightsTourWhenAllCellsFill(chess, row, col, 1);
	}

	private static void printKnightsTourWhenAllCellsFill(int[][] chess, int row, int col, int move) {
		
		// Base Condition
		if(row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] > 0) {
			return;
		}else if(move == chess.length * chess.length) {
			chess[row][col] = move;
			displayChessBoard(chess);
			chess[row][col] = 0;
			return;
		}
		
		chess[row][col] = move;
		printKnightsTourWhenAllCellsFill(chess, row - 2, col + 1, move + 1);
		printKnightsTourWhenAllCellsFill(chess, row - 1, col + 2, move + 1);
		printKnightsTourWhenAllCellsFill(chess, row + 1, col + 2, move + 1);
		printKnightsTourWhenAllCellsFill(chess, row + 2, col + 1, move + 1);
		printKnightsTourWhenAllCellsFill(chess, row + 2, col - 1, move + 1);
		printKnightsTourWhenAllCellsFill(chess, row + 1, col - 2, move + 1);
		printKnightsTourWhenAllCellsFill(chess, row - 1, col - 2, move + 1);
		printKnightsTourWhenAllCellsFill(chess, row - 2, col - 1, move + 1);
		chess[row][col] = 0;
	}

	private static void displayChessBoard(int[][] chess) {

		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				System.out.println(chess[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

}
