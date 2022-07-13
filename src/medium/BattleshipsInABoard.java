package medium;

public class BattleshipsInABoard {
	
	public static void main(String[] args) {
		int res = countBattleships(new char[][]{
				{'X', '.', '.', 'X'},
				{'.', '.', '.', 'X'},
				{'.', '.', '.', 'X'}
		});
		System.out.println(res);
	}
	
	public static int countBattleships(char[][] board) {
		int m = board.length, n = board[0].length, res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.' || i > 0 && board[i - 1][j] == 'X' || j > 0 && board[i][j - 1] == 'X') {
					continue;
				}
				res++;
			}
		}
		return res;
	}
//	public static int countBattleships(char[][] board) {
//		int m = board.length, n = board[0].length, res = 0;
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (board[i][j] == 'X') {
//					res++;
//					dfs(board, i, j, m, n);
//				}
//			}
//		}
//		return res;
//	}
//
//	private static void dfs(char[][] board, int i, int j, int m, int n) {
//		if (i < 0 || i == m || j < 0 || j == n || board[i][j] == '.') {
//			return;
//		}
//		board[i][j] = '.';
//		dfs(board, i + 1, j, m, n);
//		dfs(board, i - 1, j, m, n);
//		dfs(board, i, j + 1, m, n);
//		dfs(board, i, j - 1, m, n);
//	}
}
