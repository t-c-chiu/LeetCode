package medium;

public class Minesweeper {
	
	public static void main(String[] args) {
		char[][] res = updateBoard(new char[][]{
				{'E', 'E', 'E', 'E', 'E'},
				{'E', 'E', 'M', 'E', 'E'},
				{'E', 'E', 'E', 'E', 'E'},
				{'E', 'E', 'E', 'E', 'E'}
		}, new int[]{3, 0});
		res = updateBoard(res, new int[]{1, 2});
		for (char[] chars : res) {
			for (char c : chars) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static char[][] updateBoard(char[][] board, int[] click) {
		int r = click[0];
		int c = click[1];
		if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
			return board;
		}
		char cell = board[r][c];
		if (cell == 'B' || cell == 'X' || Character.isDigit(cell)) {
			return board;
		}
		if (cell == 'M') {
			board[r][c] = 'X';
			return board;
		}
		
		int mines = searchMines(board, r, c);
		if (mines > 0) {
			board[r][c] = Character.forDigit(mines, 10);
			return board;
		}
		board[r][c] = 'B';
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				updateBoard(board, new int[]{r + i, c + j});
			}
		}
		return board;
	}
	
	private static int searchMines(char[][] board, int r, int c) {
		int count = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				int row = r + i;
				int column = c + j;
				if (row < 0 || column < 0 || row >= board.length || column >= board[0].length) {
					continue;
				}
				if (board[row][column] == 'M' || board[row][column] == 'X') {
					count++;
				}
			}
		}
		return count;
	}
}
