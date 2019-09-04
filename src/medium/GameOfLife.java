package medium;

public class GameOfLife {
	public static void main(String[] args) {
		GameOfLife test = new GameOfLife();
		int[][] board = new int[][]{
				{0, 1, 0},
				{0, 0, 1},
				{1, 1, 1},
				{0, 0, 0}
		};
		test.gameOfLife(board);
		for (int[] row : board) {
			for (int cell : row) {
				System.out.print(cell);
			}
			System.out.println();
		}
	}
	
	//	Input:
	//	[
	//	[0,1,0],
	//	[0,0,1],
	//	[1,1,1],
	//	[0,0,0]
	//	]
	
	//	Output:
	//	[
	//	[0,0,0],
	//	[1,0,1],
	//	[0,1,1],
	//	[0,1,0]
	//	]
	public void gameOfLife(int[][] board) {
		nextState(board, 0, 0);
	}
	
	private void nextState(int[][] board, int i, int j) {
		if (i >= board.length || j >= board[i].length)
			return;
		
		int newState = computeState(board, i, j);
		if (j < board[i].length - 1)
			nextState(board, i, j + 1);
		else if (i < board.length - 1)
			nextState(board, i + 1, 0);
		board[i][j] = newState;
	}
	
	private int computeState(int[][] board, int i, int j) {
		int currentState = board[i][j];
		int liveNeighbors = 0;
		for (int row = i - 1; row <= i + 1 && row < board.length; row++) {
			if (row < 0)
				continue;
			for (int col = j - 1; col <= j + 1 && col < board[row].length; col++) {
				if (col < 0)
					continue;
				if ((row != i || col != j) && board[row][col] == 1)
					liveNeighbors++;
			}
		}
		if (currentState == 0) {
			return liveNeighbors == 3 ? 1 : 0;
		} else {
			return liveNeighbors == 2 || liveNeighbors == 3 ? 1 : 0;
		}
	}
}
