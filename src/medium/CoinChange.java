package medium;

import java.util.Arrays;

public class CoinChange {
	
	public static void main(String[] args) {
		int res = coinChange(new int[]{1, 2, 5}, 11);
		System.out.println(res);
	}
	
	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i >= coin) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
}
