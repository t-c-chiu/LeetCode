package medium;

public class BestTimeToBuyAndSellStockWithCooldown {
	
	public static void main(String[] args) {
		int res = maxProfit(new int[]{1, 2, 3, 0, 2});
		System.out.println(res);
	}
	
	public static int maxProfit(int[] prices) {
		int buy = Integer.MIN_VALUE, sell = 0, preSell = 0;
		for (int price : prices) {
			int preBuy = buy;
			buy = Math.max(buy, preSell - price);
			preSell = sell;
			sell = Math.max(sell, preBuy + price);
		}
		return sell;
	}
//	public static int maxProfit(int[] prices) {
//		int n = prices.length;
//		int[] buy = new int[n], sell = new int[n], rest = new int[n];
//		buy[0] = -prices[0];
//		for (int i = 1; i < n; i++) {
//			buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
//			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
//			rest[i] = Math.max(rest[i - 1], sell[i - 1]);
//		}
//		return sell[n - 1];
//	}
}
