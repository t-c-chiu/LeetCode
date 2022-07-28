package hard;

import java.util.Arrays;

public class SudokuSolver {
	
	public static void main(String[] args) {
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		solveSudoku(board);
		Arrays.stream(board).forEach(row -> System.out.println(Arrays.toString(row)));
	}
	
	public static void solveSudoku(char[][] board) {
		solve(board);
	}
	
	public static boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char k = '1'; k <= '9'; k++) {
						if (isValid(board, i, j, k)) {
							board[i][j] = k;
							if (solve(board)) {
								return true;
							}
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isValid(char[][] board, int i, int j, char c) {
		for (int k = 0; k < 9; k++) {
			if (board[k][j] == c || board[i][k] == c) {
				return false;
			}
		}
		int rowStart = (i / 3) * 3, colStart = (j / 3) * 3;
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				if (board[rowStart + k][colStart + l] == c) {
					return false;
				}
			}
		}
		return true;
	}
}
