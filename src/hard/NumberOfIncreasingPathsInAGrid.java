package hard;

public class NumberOfIncreasingPathsInAGrid {
	
	public static void main(String[] args) {
		int res = countPaths(new int[][]{
				{1, 1},
				{3, 4}});
		System.out.println(res);
	}
	
	static int mod = (int) 1e9 + 7;
	
	public static int countPaths(int[][] grid) {
		int res = 0, m = grid.length, n = grid[0].length;
		int[][] memo = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res = (res + dfs(grid, i, j, m, n, memo)) % mod;
			}
		}
		return res;
	}
	
	private static int dfs(int[][] grid, int i, int j, int m, int n, int[][] memo) {
		if (memo[i][j] != 0) {
			return memo[i][j];
		}
		int count = 1;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] dir : dirs) {
			int x = i + dir[0], y = j + dir[1];
			if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] < grid[i][j]) {
				count = (count + dfs(grid, x, y, m, n, memo)) % mod;
			}
		}
		memo[i][j] = count;
		return count;
	}
	
}
