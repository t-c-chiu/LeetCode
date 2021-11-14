package medium;

import java.util.Arrays;

public class CandyCrush {
	
	public static void main(String[] args) {
		int[][] res = candyCrush(new int[][]{
				{110, 5, 112, 113, 114},
				{210, 211, 5, 213, 214},
				{310, 311, 3, 313, 314},
				{410, 411, 412, 5, 414},
				{5, 1, 512, 3, 3},
				{610, 4, 1, 613, 614},
				{710, 1, 2, 713, 714},
				{810, 1, 2, 1, 1},
				{1, 1, 2, 2, 2},
				{4, 1, 4, 4, 1014}});
		for (int[] arr : res) {
			Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
			System.out.println();
		}
	}
	
	public static int[][] candyCrush(int[][] board) {
		while (crush(board)) {
			gravity(board);
		}
		return board;
	}
	
	private static boolean crush(int[][] board) {
		int m = board.length, n = board[0].length;
		boolean isCrush = false;
		for (int i = 0; i < m - 2; i++) {
			for (int j = 0; j < n; j++) {
				int num = Math.abs(board[i][j]);
				if (num == 0) {
					continue;
				}
				if (Math.abs(board[i + 1][j]) == num && Math.abs(board[i + 2][j]) == num) {
					board[i][j] = board[i + 1][j] = board[i + 2][j] = -num;
					isCrush = true;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n - 2; j++) {
				int num = Math.abs(board[i][j]);
				if (num == 0) {
					continue;
				}
				if (Math.abs(board[i][j + 1]) == num && Math.abs(board[i][j + 2]) == num) {
					board[i][j] = board[i][j + 1] = board[i][j + 2] = -num;
					isCrush = true;
				}
			}
		}
		return isCrush;
	}
	
	private static void gravity(int[][] board) {
		int m = board.length, n = board[0].length;
		for (int j = 0; j < n; j++) {
			int pos = m - 1;
			for (int i = m - 1; i >= 0; i--) {
				if (board[i][j] > 0) {
					board[pos--][j] = board[i][j];
				}
			}
			while (pos >= 0) {
				board[pos--][j] = 0;
			}
		}
	}
}
