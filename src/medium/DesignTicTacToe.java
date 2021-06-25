package medium;

public class DesignTicTacToe {
	
	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe(3);
		ticTacToe.move(0, 0, 1);
		ticTacToe.move(0, 2, 2);
		ticTacToe.move(2, 2, 1);
		ticTacToe.move(1, 1, 2);
		ticTacToe.move(2, 0, 1);
		ticTacToe.move(1, 0, 2);
		int res = ticTacToe.move(2, 1, 1);
		System.out.println(res);
	}
	
	static class TicTacToe {
		
		int[][] board;
		
		public TicTacToe(int n) {
			board = new int[n][n];
		}
		
		public int move(int row, int col, int player) {
			board[row][col] = player;
			return check(row, col, player) ? player : 0;
		}
		
		private boolean check(int row, int col, int player) {
			return checkRow(row, player) || checkCol(col, player)
					|| checkTopLeftToBottomRight(row, col, player)
					|| checkTopRightToBottomLeft(row, col, player);
		}
		
		private boolean checkRow(int row, int player) {
			for (int i = 0; i < board[row].length; i++) {
				if (board[row][i] != player) {
					return false;
				}
			}
			return true;
		}
		
		private boolean checkCol(int col, int player) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][col] != player) {
					return false;
				}
			}
			return true;
		}
		
		private boolean checkTopLeftToBottomRight(int row, int col, int player) {
			if (row != col) {
				return false;
			}
			
			for (int i = 0; i < board.length; i++) {
				if (board[i][i] != player) {
					return false;
				}
			}
			return true;
		}
		
		private boolean checkTopRightToBottomLeft(int row, int col, int player) {
			int n = board.length;
			if (row + col != n - 1) {
				return false;
			}
			
			for (int i = 0; i < n; i++) {
				if (board[i][n - i - 1] != player) {
					return false;
				}
			}
			return true;
		}
	}
}
