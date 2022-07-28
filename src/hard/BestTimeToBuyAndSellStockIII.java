package hard;

public class BestTimeToBuyAndSellStockIII {
	
	public static void main(String[] args) {
		int res = maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
		System.out.println(res);
	}
	
	public static int maxProfit(int[] prices) {
		int n = prices.length;
		if (n < 2) {
			return 0;
		}
		int[][] dp = new int[3][n];
		for (int i = 1; i <= 2; i++) {
			int maxAfterBuy = -prices[0];
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxAfterBuy);
				maxAfterBuy = Math.max(maxAfterBuy, dp[i - 1][j - 1] - prices[j]);
			}
		}
		return dp[2][n - 1];
	}
}
