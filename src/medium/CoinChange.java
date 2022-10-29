package medium;

import java.util.Arrays;

public class CoinChange {
	
	public static void main(String[] args) {
		int res = coinChange(new int[]{2}, 3);
		System.out.println(res);
	}
	
	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
}
