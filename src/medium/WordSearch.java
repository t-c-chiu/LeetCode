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
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean dfs(char[][] board, int i, int j, String word, int pos) {
		if (pos == word.length()) {
			return true;
		}
		if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(pos)) {
			return false;
		}
		board[i][j] = '.';
		boolean res = dfs(board, i - 1, j, word, pos + 1) ||
				dfs(board, i + 1, j, word, pos + 1) ||
				dfs(board, i, j - 1, word, pos + 1) ||
				dfs(board, i, j + 1, word, pos + 1);
		board[i][j] = word.charAt(pos);
		return res;
	}
}
