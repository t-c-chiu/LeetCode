package hard;

public class EditDistance {
	
	public static void main(String[] args) {
		int res = minDistance("", "a");
		System.out.println(res);
	}
	
	public static int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char c1 = word1.charAt(i - 1), c2 = word2.charAt(j - 1);
				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}
			}
		}
		return dp[m][n];
	}
//	public static int minDistance(String word1, String word2) {
//		return helper(word1, word2, 0, 0, new Integer[word1.length()][word2.length()]);
//	}
//
//	private static int helper(String word1, String word2, int i, int j, Integer[][] memo) {
//		if (i == word1.length()) {
//			return word2.length() - j;
//		}
//		if (j == word2.length()) {
//			return word1.length() - i;
//		}
//		if (memo[i][j] != null) {
//			return memo[i][j];
//		}
//		char c1 = word1.charAt(i), c2 = word2.charAt(j);
//		if (c1 == c2) {
//			memo[i][j] = helper(word1, word2, i + 1, j + 1, memo);
//		} else {
//			int insert = helper(word1, word2, i, j + 1, memo);
//			int delete = helper(word1, word2, i + 1, j, memo);
//			int replace = helper(word1, word2, i + 1, j + 1, memo);
//			memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
//		}
//		return memo[i][j];
//	}
}
