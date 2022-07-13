package medium;

public class MaximumProfitFromTradingStocks {
	
	public static void main(String[] args) {
		int res = maximumProfit(new int[]{5, 4, 6, 2, 3}, new int[]{8, 5, 4, 3, 5}, 10);
		System.out.println(res);
	}
	
	public static int maximumProfit(int[] present, int[] future, int budget) {
		return helper(present, future, budget, 0, new Integer[present.length][budget + 1]);
	}
	
	private static int helper(int[] present, int[] future, int budget, int i, Integer[][] memo) {
		if (i == present.length) {
			return 0;
		}
		if (memo[i][budget] != null) {
			return memo[i][budget];
		}
		int buy = 0, notBuy;
		if (budget >= present[i] && future[i] > present[i]) {
			buy = helper(present, future, budget - present[i], i + 1, memo) + future[i] - present[i];
		}
		notBuy = helper(present, future, budget, i + 1, memo);
		memo[i][budget] = Math.max(buy, notBuy);
		return memo[i][budget];
	}
//	public static int maximumProfit(int[] present, int[] future, int budget) {
//		int[] dp = new int[budget + 1];
//		for (int i = 0; i < present.length; i++) {
//			for (int j = budget; j >= present[i]; j--) {
//				if (future[i] > present[i]) {
//					dp[j] = Math.max(dp[j], dp[j - present[i]] + future[i] - present[i]);
//				}
//			}
//		}
//		return dp[budget];
//	}
}
