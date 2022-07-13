package medium;

public class CountNumberOfTexts {
	
	public static void main(String[] args) {
		int res = countTexts("22233");
		System.out.println(res);
	}
	
	public static int countTexts(String pressedKeys) {
		int n = pressedKeys.length(), mod = (int) (Math.pow(10, 9) + 7);
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] % mod;
			char digit = pressedKeys.charAt(i - 1);
			if (i - 2 >= 0 && digit == pressedKeys.charAt(i - 2)) {
				dp[i] = (dp[i] + dp[i - 2]) % mod;
				if (i - 3 >= 0 && digit == pressedKeys.charAt(i - 3)) {
					dp[i] = (dp[i] + dp[i - 3]) % mod;
					if ((digit == '7' || digit == '9') && i - 4 >= 0 && digit == pressedKeys.charAt(i - 4)) {
						dp[i] = (dp[i] + dp[i - 4]) % mod;
					}
				}
			}
		}
		return dp[n];
	}
}
