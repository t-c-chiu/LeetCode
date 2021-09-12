package medium;

import java.util.Arrays;

public class LargestPlusSign {
	
	public static void main(String[] args) {
		int res = orderOfLargestPlusSign(5, new int[][]{{4, 2}});
		System.out.println(res);
	}
	
	public static int orderOfLargestPlusSign(int n, int[][] mines) {
		int[][] dp = new int[n][n];
		for (int[] row : dp) {
			Arrays.fill(row, n);
		}
		for (int[] mine : mines) {
			dp[mine[0]][mine[1]] = 0;
		}
		
		for (int i = 0; i < n; i++) {
			int left = 0, right = 0, up = 0, down = 0;
			for (int j = 0, k = n - 1; j < n; j++, k--) {
				left = dp[i][j] == 0 ? 0 : left + 1;
				dp[i][j] = Math.min(dp[i][j], left);
				
				right = dp[i][k] == 0 ? 0 : right + 1;
				dp[i][k] = Math.min(dp[i][k], right);
				
				up = dp[k][i] == 0 ? 0 : up + 1;
				dp[k][i] = Math.min(dp[k][i], up);
				
				down = dp[j][i] == 0 ? 0 : down + 1;
				dp[j][i] = Math.min(dp[j][i], down);
			}
		}
		
		int res = 0;
		for (int[] row : dp) {
			for (int count : row) {
				res = Math.max(res, count);
			}
		}
		return res;
	}
}
