package hard;

public class BestTimeToBuyAndSellStockIV {
	
	public static void main(String[] args) {
		int res = maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
		System.out.println(res);
	}
	
	public static int maxProfit(int k, int[] prices) {
		int n = prices.length;
		if (n < 2) {
			return 0;
		}
		int[][] dp = new int[k + 1][n];
		for (int i = 1; i <= k; i++) {
			int maxAfterBuy = -prices[0];
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], maxAfterBuy + prices[j]);
				maxAfterBuy = Math.max(maxAfterBuy, dp[i - 1][j - 1] - prices[j]);
			}
		}
		return dp[k][n - 1];
	}
}
