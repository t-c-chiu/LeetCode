package medium;

public class Maximal_Square {
	
	public static void main(String[] args) {
		Maximal_Square test = new Maximal_Square();
		int res = test.maximalSquare(new char[][]{
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '1', '1', '1'}
		});
		System.out.println(res);
	}
	
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int maxSideLen = 0, m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					maxSideLen = Math.max(maxSideLen, dp[i][j]);
				}
			}
		}
		return maxSideLen * maxSideLen;
	}
}
