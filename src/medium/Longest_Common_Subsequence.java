package medium;

public class Longest_Common_Subsequence {
	
	public static void main(String[] args) {
		Longest_Common_Subsequence test = new Longest_Common_Subsequence();
		int res = test.longestCommonSubsequence("abcde", "akzccxdeb");
		System.out.println(res);
	}
	
	public int longestCommonSubsequence(String text1, String text2) {
		if (text1.isEmpty() || text2.isEmpty()) {
			return 0;
		}
		int t1Len = text1.length(), t2Len = text2.length();
		// dp[i][j] = LCS between text1(0, i) and text2(0, j)
		int[][] dp = new int[t1Len + 1][t2Len + 1];
		for (int i = 1; i <= t1Len; i++) {
			for (int j = 1; j <= t2Len; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[t1Len][t2Len];
	}
}
