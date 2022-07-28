package hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	
	public static void main(String[] args) {
		List<List<String>> res = solveNQueens(4);
		System.out.println(res);
	}
	
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		helper(res, board, 0, n);
		return res;
	}
	
	private static void helper(List<List<String>> res, char[][] board, int row, int n) {
		if (row == n) {
			res.add(construct(board));
			return;
		}
		for (int j = 0; j < n; j++) {
			if (isValid(board, row, j)) {
				board[row][j] = 'Q';
				helper(res, board, row + 1, n);
				board[row][j] = '.';
			}
		}
	}
	
	private static boolean isValid(char[][] board, int i, int j) {
		for (int k = i; k >= 0; k--) {
			if (board[k][j] == 'Q') {
				return false;
			}
		}
		for (int k = i, l = j; k >= 0 && l >= 0; k--, l--) {
			if (board[k][l] == 'Q') {
				return false;
			}
		}
		for (int k = i, l = j; k >= 0 && l < board.length; k--, l++) {
			if (board[k][l] == 'Q') {
				return false;
			}
		}
		return true;
	}
	
	private static List<String> construct(char[][] board) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			StringBuilder row = new StringBuilder();
			for (int j = 0; j < board.length; j++) {
				row.append(board[i][j]);
			}
			res.add(row.toString());
		}
		return res;
	}
}
