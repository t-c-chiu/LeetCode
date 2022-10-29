package medium;

public class DecodeWays {
	
	public static void main(String[] args) {
		int res = numDecodings("10001");
		System.out.println(res);
	}
	
	public static int numDecodings(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			char c = s.charAt(i);
			char prevC = s.charAt(i - 1);
			if (c != '0') {
				dp[i] = dp[i - 1];
			}
			if (prevC == '1' || prevC == '2' && c <= '6') {
				dp[i] += i == 1 ? 1 : dp[i - 2];
			}
		}
		return dp[n - 1];
	}
//	public static int numDecodings(String s) {
//		if (s.charAt(0) == '0') {
//			return 0;
//		}
//		int n = s.length();
//		int[] dp = new int[n + 1];
//		dp[0] = dp[1] = 1;
//		for (int i = 1; i < n; i++) {
//			char prev = s.charAt(i - 1);
//			char cur = s.charAt(i);
//			if (cur != '0') {
//				dp[i + 1] = dp[i];
//			}
//			if (prev == '1' || prev == '2' && cur <= '6') {
//				dp[i + 1] += dp[i - 1];
//			}
//		}
//		return dp[n];
//	}
}
