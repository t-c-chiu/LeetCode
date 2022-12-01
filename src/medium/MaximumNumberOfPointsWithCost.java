package medium;

public class MaximumNumberOfPointsWithCost {
	
	public static void main(String[] args) {
		long res = maxPoints(new int[][]{
				{1, 2, 3},
				{1, 5, 1},
				{3, 1, 1}});
		System.out.println(res);
	}
	
	public static long maxPoints(int[][] points) {
		long res = 0;
		int m = points.length, n = points[0].length;
		long[][] dp = new long[m][n];
		for (int j = 0; j < n; j++) {
			dp[0][j] = points[0][j];
		}
		for (int i = 1; i < m; i++) {
			long[] left = new long[n];
			left[0] = dp[i - 1][0];
			for (int j = 1; j < n; j++) {
				left[j] = Math.max(dp[i - 1][j], left[j - 1] - 1);
			}
			long[] right = new long[n];
			right[n - 1] = dp[i - 1][n - 1];
			for (int j = n - 2; j >= 0; j--) {
				right[j] = Math.max(dp[i - 1][j], right[j + 1] - 1);
			}
			for (int j = 0; j < n; j++) {
				dp[i][j] = Math.max(dp[i][j], Math.max(left[j], right[j]) + points[i][j]);
			}
		}
		for (int j = 0; j < n; j++) {
			res = Math.max(res, dp[m - 1][j]);
		}
		return res;
	}
}
