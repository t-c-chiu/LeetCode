package medium;

public class DecodeWays {
	
	public static void main(String[] args) {
		DecodeWays test = new DecodeWays();
		int res = test.numDecodings("226");
		System.out.println(res);
	}
	
	/**
	 * 1 -> A -> 1way
	 * 12 -> AB, L -> 2ways
	 * 122 = 1 + 22 or 12 + 2 = 1way + 2ways = 3ways -> AV, ABB, LB
	 * 1221 = 12 + 21 or 122 + 1 = 2ways + 3ways = 5ways -> ABU, LU, AVA, ABBA, LBA
	 */
	public int numDecodings(String s) {
		if (s.isEmpty() || s.charAt(0) == '0') {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;
		for (int i = 1; i < n; i++) {
			int curDigit = s.charAt(i) - '0';
			if (curDigit != 0) {
				dp[i + 1] += dp[i];
			}
			int lastTwoDigits = (s.charAt(i - 1) - '0') * 10 + curDigit;
			if (lastTwoDigits >= 10 && lastTwoDigits <= 26) {
				dp[i + 1] += dp[i - 1];
			}
		}
		return dp[n];
	}
}
