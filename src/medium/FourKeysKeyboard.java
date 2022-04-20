package medium;

public class FourKeysKeyboard {
	
	public static void main(String[] args) {
		int res = maxA(7);
		System.out.println(res);
	}
	
	public static int maxA(int n) {
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = i;
			for (int j = 1; j <= i - 3; j++) {
				dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
			}
		}
		return dp[n];
	}
}
