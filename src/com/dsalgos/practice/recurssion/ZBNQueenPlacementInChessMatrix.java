package com.dsalgos.practice.recurssion;

public class ZBNQueenPlacementInChessMatrix {
	
	public static void main(String[] args) {
		
		int[][] chessBoard = {{0, 0, 0, 0, },
				  			  {0, 0, 0, 0, },
				  			  {0, 0, 0, 0, },
				  			  {0, 0, 0, 0, }};
		
		nQueenPlaceMent(chessBoard, 0, 0, "");
	}

	private static void nQueenPlaceMent(int[][] chess, int row, int col, String ans) {
		// we will only check for number of rows as we have to place queens 1 in each row
		// consider each row as 1 level
		
		if(row == chess.length) {
			System.out.println(ans);
			return;
		}
		// for each row we will have n = chess[0].length options to place the queen at each level
		for (col = 0; col < chess[0].length; col++) {
			// check if the current row and column is the same place to put the quuen
			if(isSafePlaceForQueen(chess, row, col) == true) { // place queen only it its safe
				chess[row][col] = 1;
				nQueenPlaceMent(chess, row + 1, col, ans + row + "-"+ col +", ");
		// while coming out of recursion make sure that we remove the queen which is placed for next iteration
				chess[row][col] = 0; 
			}
		}
	}

	private static boolean isSafePlaceForQueen(int[][] chess, int row, int col) {
		// above loop to check straight above rows
		for (int i = row - 1, j = col; i >= 0; i--) {
			if(chess[i][j] ==  1) {
				return false;
			}
		}
		// check left diagonal up row and col both will decrease
		for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
			if(chess[i][j] == 1) {
				return false;
			}
		}
		// check right diagonal up row will decrease but col will increase
		for (int i = row-1, j = col+1; i >= 0 && j < chess[0].length ; i--, j++) {
			if(chess[i][j] == 1) {
				return false;
			}
		}
		// if the code reaches here, means that row and col position is safe to place the Queen
		return true;
	}
}
