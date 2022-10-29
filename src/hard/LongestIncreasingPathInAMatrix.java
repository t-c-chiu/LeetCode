package hard;

public class LongestIncreasingPathInAMatrix {
	
	public static void main(String[] args) {
		int res = longestIncreasingPath(new int[][]{
				{9, 9, 4},
				{6, 6, 8},
				{2, 1, 1}});
		System.out.println(res);
	}
	
	public static int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length, res = 0;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res = Math.max(res, dfs(matrix, i, j, m, n, dp));
			}
		}
		return res;
	}
	
	private static int dfs(int[][] matrix, int i, int j, int m, int n, int[][] dp) {
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		dp[i][j] = 1;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] dir : dirs) {
			int r = i + dir[0], c = j + dir[1];
			if (r < 0 || r == m || c < 0 || c == n || matrix[r][c] <= matrix[i][j]) {
				continue;
			}
			dp[i][j] = Math.max(dp[i][j], dfs(matrix, r, c, m, n, dp) + 1);
		}
		return dp[i][j];
	}
	
}
