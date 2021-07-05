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
		int res = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					res = Math.max(res, dfs(grid, i, j));
				}
			}
		}
		return res;
	}
	
	private static int dfs(int[][] grid, int i, int j) {
		int m = grid.length;
		int n = grid[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
			return 0;
		}
		
		grid[i][j] = 0;
		int area = 1;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] dir : dirs) {
			area += dfs(grid, i + dir[0], j + dir[1]);
		}
		return area;
	}
	
}
