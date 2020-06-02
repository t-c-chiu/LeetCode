package medium;

import java.util.HashSet;
import java.util.Set;

public class Valid_Sudoku {
	
	public static void main(String[] args) {
		Valid_Sudoku test = new Valid_Sudoku();
		test.isValidSudoku(new char[9][9]);
	}
	
	public boolean isValidSudoku(char[][] board) {
		Set<String> seen = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c != '.' && (!seen.add(i + "row: " + c) ||
						!seen.add(j + " col: " + c) ||
						!seen.add(i / 3 + " block " + j / 3 + ": " + c))) {
					return false;
				}
			}
		}
		return true;
	}
}
