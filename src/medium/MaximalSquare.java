package medium;

public class MaximalSquare {
	
	public static void main(String[] args) {
		int res = maximalSquare(new char[][]{
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '1', '1', '1'}
		});
		System.out.println(res);
	}
	
	public static int maximalSquare(char[][] matrix) {
		int res = 0, m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = matrix[i][j] - '0';
				} else {
					dp[i][j] = matrix[i][j] == '0' ? 0 : Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
				res = Math.max(res, dp[i][j]);
			}
		}
		return res * res;
	}
}
