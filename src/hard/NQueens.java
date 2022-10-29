package hard;

import java.util.ArrayList;
import java.util.Arrays;
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
			Arrays.fill(board[i], '.');
		}
		solveNQueens(res, board, 0, n);
		return res;
	}
	
	private static void solveNQueens(List<List<String>> res, char[][] board, int r, int n) {
		if (r == n) {
			res.add(construct(board));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isValid(board, r, i, n)) {
				board[r][i] = 'Q';
				solveNQueens(res, board, r + 1, n);
				board[r][i] = '.';
			}
		}
	}
	
	private static boolean isValid(char[][] board, int r, int c, int n) {
		for (int i = 0; i < r; i++) {
			if (board[i][c] == 'Q') {
				return false;
			}
		}
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}
		for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
			if (board[i][j] == 'Q') {
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
