package medium;

public class Word_Search {
	
	public static void main(String[] args) {
		Word_Search test = new Word_Search();
		test.exist(new char[][]{
						{'A', 'B', 'C', 'E'},
						{'S', 'F', 'C', 'S'},
						{'A', 'D', 'E', 'E'}},
				"ABCCED");
	}
	
	public boolean exist(char[][] board, String word) {
		char[] chars = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (exist(board, i, j, chars, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean exist(char[][] board, int i, int j, char[] chars, int k) {
		if (i < 0 || j < 0 || i == board.length || j == board[i].length || board[i][j] != chars[k]) {
			return false;
		}
		if (k == chars.length - 1) {
			return true;
		}
		board[i][j] = '*';
		boolean exist = exist(board, i - 1, j, chars, k + 1) ||
				exist(board, i + 1, j, chars, k + 1) ||
				exist(board, i, j - 1, chars, k + 1) ||
				exist(board, i, j + 1, chars, k + 1);
		board[i][j] = chars[k];
		return exist;
	}
}
