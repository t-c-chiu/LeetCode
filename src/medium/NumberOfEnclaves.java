package medium;

public class NumberOfEnclaves {
	
	public static void main(String[] args) {
		int res = numEnclaves(new int[][]{
				{0, 0, 0, 0},
				{1, 0, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}});
		System.out.println(res);
	}
	
	public static int numEnclaves(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			dfs(grid, i, 0);
			dfs(grid, i, n - 1);
		}
		for (int j = 0; j < n; j++) {
			dfs(grid, 0, j);
			dfs(grid, m - 1, j);
		}
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					res++;
				}
			}
		}
		return res;
	}
	
	private static void dfs(int[][] grid, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}
}
