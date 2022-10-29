package hard;

public class PathsInMatrixWhoseSumIsDivisibleByK {
	
	public static void main(String[] args) {
		int res = numberOfPaths(new int[][]{
				{5, 2, 4},
				{3, 0, 5},
				{0, 7, 2}}, 3);
		System.out.println(res);
	}
	
	public static int numberOfPaths(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length, mod = (int) (1e9 + 7);
		int[][][] dp = new int[m][n][k];
		dp[0][0][grid[0][0] % k] = 1;
		for (int i = 1; i < m; i++) {
			for (int l = 0; l < k; l++) {
				dp[i][0][(l + grid[i][0]) % k] = dp[i - 1][0][l];
			}
		}
		for (int j = 1; j < n; j++) {
			for (int l = 0; l < k; l++) {
				dp[0][j][(l + grid[0][j]) % k] = dp[0][j - 1][l];
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				for (int l = 0; l < k; l++) {
					dp[i][j][(l + grid[i][j]) % k] = (dp[i - 1][j][l] + dp[i][j - 1][l]) % mod;
				}
			}
		}
		return dp[m - 1][n - 1][0];
	}
}
