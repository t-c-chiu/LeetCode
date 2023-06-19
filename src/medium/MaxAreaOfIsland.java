package medium;

public class MaxAreaOfIsland {
	
	public static void main(String[] args) {
		int res = maxAreaOfIsland(new int[][]{
				{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
				{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
		});
		System.out.println(res);
	}
	
	public static int maxAreaOfIsland(int[][] grid) {
		int res = 0, m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					res = Math.max(res, dfs(grid, i, j, m, n));
				}
			}
		}
		return res;
	}
	
	private static int dfs(int[][] grid, int i, int j, int m, int n) {
		if (i < 0 || i == m || j < 0 || j == n || grid[i][j] == 0) {
			return 0;
		}
		int area = 1;
		grid[i][j] = 0;
		area += dfs(grid, i - 1, j, m, n) + dfs(grid, i + 1, j, m, n) + dfs(grid, i, j - 1, m, n) + dfs(grid, i, j + 1, m, n);
		return area;
	}
	
}
