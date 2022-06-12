package hard;

public class StrangePrinter {
	
	public static void main(String[] args) {
		int res = strangePrinter("aaabbb");
		System.out.println(res);
	}
	
	public static int strangePrinter(String s) {
		s = removeDuplicate(s);
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
			if (i > 0) {
				dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i) ? 1 : 2;
			}
		}
		for (int len = 2; len < n; len++) {
			for (int start = 0; start + len < n; start++) {
				int end = start + len;
				dp[start][end] = len + 1;
				for (int k = 0; k < len; k++) {
					dp[start][end] = Math.min(dp[start][end], dp[start][start + k] + dp[start + k + 1][end]);
				}
				if (s.charAt(start) == s.charAt(end)) {
					dp[start][end]--;
				}
			}
		}
		return dp[0][n - 1];
	}
	
	private static String removeDuplicate(String s) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
				continue;
			}
			builder.append(s.charAt(i));
		}
		return builder.toString();
	}
}
