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
		
		int[] rows;
		int[] cols;
		int diagonal;
		int antiDiagonal;
		
		public TicTacToe(int n) {
			rows = new int[n];
			cols = new int[n];
		}
		
		public int move(int row, int col, int player) {
			int n = rows.length;
			int add = player == 1 ? 1 : -1;
			rows[row] += add;
			cols[col] += add;
			if (row == col) {
				diagonal += add;
			}
			if (row + col == n - 1) {
				antiDiagonal += add;
			}
			if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
				return player;
			}
			return 0;
		}
	}
}
