package medium;

public class BestTimeToBuyAndSellStockWithCooldown {
	
	public static void main(String[] args) {
		int res = maxProfit(new int[]{1, 2, 3, 0, 2});
		System.out.println(res);
	}
	
	// buy -> buy or sell
	// sell -> rest
	// rest -> rest or buy
	// 陣列[i] = 第i + 1天狀態為該操作的最大收益
	public static int maxProfit(int[] prices) {
		int n = prices.length;
		int[] buy = new int[n];
		int[] sell = new int[n];
		int[] rest = new int[n];
		buy[0] = -prices[0];
		for (int i = 1; i < n; i++) {
			buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
			rest[i] = Math.max(rest[i - 1], sell[i - 1]);
		}
		return sell[n - 1];
	}
}
