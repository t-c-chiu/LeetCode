package medium;

public class BestTimeToBuyAndSellStockWithCooldown {
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockWithCooldown test = new BestTimeToBuyAndSellStockWithCooldown();
		System.out.println(test.maxProfit(new int[]{1, 2, 3, 0, 2}));
	}
	
	// buy -> buy or sell
	// sell -> rest
	// rest -> rest or buy
	// 陣列[i] = 第i + 1天狀態為該操作的最大收益
	public int maxProfit(int[] prices) {
		final int n = prices.length;
		if (n < 2)
			return 0;
		
		int[] buy = new int[n];
		int[] sell = new int[n];
		int[] rest = new int[n];
		buy[0] = -prices[0];
		for (int i = 1; i < n; i++) {
			// 不買或買, 買的話最大收益會是到昨天為止休息的最大收益 - 當天價格 (因為至少要休息一天才能買)
			buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
			// 繼續持有或賣, 賣的話最大收益會是到昨天為止買的最大收益 + 當天價格
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
			// 賣完休息, 或是昨天已經休息, 今天繼續休息
			rest[i] = Math.max(rest[i - 1], sell[i - 1]);
		}
		return sell[n - 1];
	}
}
