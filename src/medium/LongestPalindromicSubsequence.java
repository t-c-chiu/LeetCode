package medium;

public class LongestPalindromicSubsequence {
	
	public static void main(String[] args) {
		int res = longestPalindromeSubseq("bbbab");
		System.out.println(res);
	}
	
	public static int longestPalindromeSubseq(String s) {
		int n = s.length();
		return helper(s, 0, n - 1, new Integer[n][n]);
	}
	
	private static int helper(String s, int from, int to, Integer[][] memo) {
		if (memo[from][to] != null) {
			return memo[from][to];
		}
		if (from == to) {
			return 1;
		}
		if (from > to) {
			return 0;
		}
		if (s.charAt(from) == s.charAt(to)) {
			memo[from][to] = helper(s, from + 1, to - 1, memo) + 2;
		} else {
			memo[from][to] = Math.max(helper(s, from + 1, to, memo), helper(s, from, to - 1, memo));
		}
		return memo[from][to];
	}
//	public static int longestPalindromeSubseq(String s) {
//		int n = s.length();
//		int[][] dp = new int[n][n];
//		for (int i = n - 1; i >= 0; i--) {
//			dp[i][i] = 1;
//			for (int j = i + 1; j < n; j++) {
//				if (s.charAt(i) == s.charAt(j)) {
//					dp[i][j] = dp[i + 1][j - 1] + 2;
//				} else {
//					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//				}
//			}
//		}
//		return dp[0][n - 1];
//	}
}
