package medium;

import java.util.Arrays;

public class WhereWillTheBallFall {
	
	public static void main(String[] args) {
		int[] res = findBall(new int[][]{
				{1, 1, 1, 1, 1, 1},
				{-1, -1, -1, -1, -1, -1},
				{1, 1, 1, 1, 1, 1},
				{-1, -1, -1, -1, -1, -1}});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] findBall(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[] res = new int[n];
		for (int j = 0; j < n; j++) {
			res[j] = helper(grid, 0, j, m, n);
		}
		return res;
	}
	
	private static int helper(int[][] grid, int row, int col, int m, int n) {
		if (row == m) {
			return col;
		}
		if (grid[row][col] == 1 && col + 1 < n && grid[row][col + 1] == 1) {
			return helper(grid, row + 1, col + 1, m, n);
		}
		if (grid[row][col] == -1 && col - 1 >= 0 && grid[row][col - 1] == -1) {
			return helper(grid, row + 1, col - 1, m, n);
		}
		return -1;
	}
}
