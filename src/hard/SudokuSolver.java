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
		solve(board, 0, 0);
	}
	
	private static boolean solve(char[][] board, int i, int j) {
		if (i == 9) {
			return true;
		}
		if (j == 9) {
			return solve(board, i + 1, 0);
		}
		if (board[i][j] != '.') {
			return solve(board, i, j + 1);
		}
		for (char c = '1'; c <= '9'; c++) {
			if (isValid(board, i, j, c)) {
				board[i][j] = c;
				if (solve(board, i, j + 1)) {
					return true;
				}
				board[i][j] = '.';
			}
		}
		return false;
	}
	
	private static boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			// 4,5 -> 3,3 3,4 3,5 4,3
			int blockRow = 3 * (row / 3), blockCol = 3 * (col / 3);
			if (board[i][col] == c || board[row][i] == c || board[blockRow + i / 3][blockCol + i % 3] == c) {
				return false;
			}
		}
		return true;
	}
}
