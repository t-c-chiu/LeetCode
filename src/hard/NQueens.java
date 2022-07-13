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
	
	private static void helper(List<List<String>> res, char[][] chars, int i, int n) {
		if (i == n) {
			res.add(construct(chars));
			return;
		}
		for (int j = 0; j < n; j++) {
			if (isValid(chars, i, j)) {
				chars[i][j] = 'Q';
				helper(res, chars, i + 1, n);
				chars[i][j] = '.';
			}
		}
	}
	
	private static boolean isValid(char[][] chars, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (chars[k][j] == 'Q') {
				return false;
			}
		}
		for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
			if (chars[x][y] == 'Q') {
				return false;
			}
		}
		for (int x = i - 1, y = j + 1; x >= 0 && y < chars.length; x--, y++) {
			if (chars[x][y] == 'Q') {
				return false;
			}
		}
		return true;
	}
	
	private static List<String> construct(char[][] chars) {
		List<String> list = new ArrayList<>();
		for (char[] row : chars) {
			StringBuilder sb = new StringBuilder();
			for (char c : row) {
				sb.append(c);
			}
			list.add(sb.toString());
		}
		return list;
	}
	
}
