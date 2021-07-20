package medium;

public class UncrossedLines {
	
	public static void main(String[] args) {
		int res = maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2});
		System.out.println(res);
	}
	
	public static int maxUncrossedLines(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
	}
}
