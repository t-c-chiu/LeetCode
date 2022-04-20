package medium;

public class MaximumNonNegativeProductInAMatrix {
	
	public static void main(String[] args) {
		int res = maxProductPath(new int[][]{
				{1, -2, 1},
				{1, -2, 1},
				{3, -4, 1}
		});
		System.out.println(res);
	}
	
	public static int maxProductPath(int[][] grid) {
		int m = grid.length, n = grid[0].length, mod = (int) Math.pow(10, 9) + 7;
		long[][][] dp = new long[m][n][2];
		dp[0][0][0] = dp[0][0][1] = grid[0][0];
		for (int i = 1; i < m; i++) {
			dp[i][0][0] = dp[i][0][1] = dp[i - 1][0][0] * grid[i][0];
		}
		for (int j = 1; j < n; j++) {
			dp[0][j][0] = dp[0][j][1] = dp[0][j - 1][0] * grid[0][j];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				int num = grid[i][j];
				if (num < 0) {
					dp[i][j][0] = num * Math.max(dp[i - 1][j][1], dp[i][j - 1][1]);
					dp[i][j][1] = num * Math.min(dp[i - 1][j][0], dp[i][j - 1][0]);
				} else {
					dp[i][j][0] = num * Math.min(dp[i - 1][j][0], dp[i][j - 1][0]);
					dp[i][j][1] = num * Math.max(dp[i - 1][j][1], dp[i][j - 1][1]);
				}
			}
		}
		return dp[m - 1][n - 1][1] < 0 ? -1 : (int) (dp[m - 1][n - 1][1] % mod);
	}
}
