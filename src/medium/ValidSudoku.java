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
		for (int i = 0; i < 9; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c == '.') {
					continue;
				}
				if (set.contains(c)) {
					return false;
				}
				set.add(c);
			}
		}
		for (int j = 0; j < 9; j++) {
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < 9; i++) {
				char c = board[i][j];
				if (c == '.') {
					continue;
				}
				if (set.contains(c)) {
					return false;
				}
				set.add(c);
			}
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				Set<Character> set = new HashSet<>();
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						char c = board[i + k][j + l];
						if (c == '.') {
							continue;
						}
						if (set.contains(c)) {
							return false;
						}
						set.add(c);
					}
				}
			}
		}
		return true;
	}
}
