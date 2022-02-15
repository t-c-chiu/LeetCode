package medium;

public class WordSearch {
	
	public static void main(String[] args) {
		boolean res = exist(new char[][]{
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'E', 'S'},
				{'A', 'D', 'E', 'E'}
		}, "ABCESEEEFS");
		System.out.println(res);
	}
	
	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (exist(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean exist(char[][] board, int i, int j, String word, int k) {
		if (k == word.length()) {
			return true;
		}
		if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(k)) {
			return false;
		}
		board[i][j] = '*';
		boolean res = exist(board, i + 1, j, word, k + 1)
				|| exist(board, i - 1, j, word, k + 1)
				|| exist(board, i, j + 1, word, k + 1)
				|| exist(board, i, j - 1, word, k + 1);
		board[i][j] = word.charAt(k);
		return res;
	}
	
}
