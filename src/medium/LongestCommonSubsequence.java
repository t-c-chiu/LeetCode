package medium;

public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		int res = longestCommonSubsequence("abcde", "ace");
		System.out.println(res);
	}
	
	/**
	 * a b c d e
	 * b d e
	 */
	public static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		return dp[m][n];
	}
}
