package medium;

import java.util.Arrays;

public class Coin_Change {
	
	public static void main(String[] args) {
		Coin_Change test = new Coin_Change();
		int res = test.coinChange(new int[]{1, 2, 5}, 11);
		System.out.println(res);
	}
	
	// dp[i] = fewest number of coins to make up i
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
					// + 1 means there is a coin
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
}
