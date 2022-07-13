package medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	
	public static void main(String[] args) {
		boolean res = isValidSudoku(new char[][]{
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
		System.out.println(res);
	}
	
	public static boolean isValidSudoku(char[][] board) {
		int m = board.length, n = board[0].length;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char c = board[i][j];
				if (c == '.') {
					continue;
				}
				if (!set.add(c + " in row " + i) ||
						!set.add(c + " in col " + j) ||
						!set.add(c + " in block " + i / 3 + ":" + j / 3)) {
					return false;
				}
			}
		}
		return true;
	}
}
