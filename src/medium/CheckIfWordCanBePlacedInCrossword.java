package medium;

public class CheckIfWordCanBePlacedInCrossword {
	
	public static void main(String[] args) {
		boolean res = placeWordInCrossword(new char[][]{
				{'#', ' ', '#'},
				{' ', ' ', '#'},
				{'#', 'c', ' '}}, "abc");
		System.out.println(res);
	}
	
	public static boolean placeWordInCrossword(char[][] board, String word) {
		char[][] rotatedBoard = rotate(board);
		String reversedWord = new StringBuilder(word).reverse().toString();
		return helper(board, word) || helper(board, reversedWord) || helper(rotatedBoard, word) || helper(rotatedBoard, reversedWord);
	}
	
	private static boolean helper(char[][] board, String word) {
		for (char[] row : board) {
			String[] segments = new String(row).split("#");
			for (String s : segments) {
				if (word.length() == s.length() && canFit(word, s)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean canFit(String word, String s) {
		for (int i = 0; i < word.length(); i++) {
			if (s.charAt(i) != ' ' && s.charAt(i) != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	private static char[][] rotate(char[][] board) {
		int m = board.length, n = board[0].length;
		char[][] rotatedBoard = new char[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				rotatedBoard[j][i] = board[i][j];
			}
		}
		return rotatedBoard;
	}
	
}
