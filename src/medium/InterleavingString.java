package medium;

public class InterleavingString {
	
	public static void main(String[] args) {
		boolean res = isInterleave("aabcc", "dbbca", "aadbbcbcac");
		System.out.println(res);
	}
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if (len1 + len2 != len3) {
			return false;
		}
		boolean[][] dp = new boolean[len1 + 1][len2 + 1];
		dp[0][0] = true;
		for (int i = 1; i < len1 + 1; i++) {
			dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
			if (!dp[i][0]) {
				break;
			}
		}
		for (int j = 1; j < len2 + 1; j++) {
			dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
			if (!dp[0][j]) {
				break;
			}
		}
		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				char c = s3.charAt(i + j - 1);
				dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == c)
						|| dp[i][j - 1] && (s2.charAt(j - 1) == c);
			}
		}
		return dp[len1][len2];
	}
}
