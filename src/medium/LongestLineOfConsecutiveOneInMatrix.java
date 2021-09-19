package medium;

public class LongestLineOfConsecutiveOneInMatrix {
	
	public static void main(String[] args) {
		int res = longestLine(new int[][]{
				{1, 1, 1, 1},
				{0, 1, 1, 0},
				{0, 0, 1, 1},
				{0, 0, 1, 1},
				{0, 0, 1, 0},
		});
		System.out.println(res);
	}
	
	public static int longestLine(int[][] mat) {
		int m = mat.length, n = mat[0].length, res = 0;
		int[][][] dp = new int[m][n][4];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					continue;
				}
				for (int k = 0; k < 4; k++) {
					dp[i][j][k] = 1;
				}
				if (j > 0) {
					dp[i][j][0] += dp[i][j - 1][0];
				}
				if (i > 0) {
					dp[i][j][1] += dp[i - 1][j][1];
				}
				if (i > 0 && j > 0) {
					dp[i][j][2] += dp[i - 1][j - 1][2];
				}
				if (i > 0 && j < n - 1) {
					dp[i][j][3] += dp[i - 1][j + 1][3];
				}
				for (int k = 0; k < 4; k++) {
					res = Math.max(res, dp[i][j][k]);
				}
			}
		}
		return res;
	}
}
