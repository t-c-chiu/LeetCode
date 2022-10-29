package medium;

public class BestTimeToBuyAndSellStockWithTransactionFee {
	
	public static void main(String[] args) {
		int res = maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
		System.out.println(res);
	}
	
	public static int maxProfit(int[] prices, int fee) {
		int buy = -prices[0], sell = 0;
		for (int i = 1; i < prices.length; i++) {
			int preBuy = buy;
			buy = Math.max(buy, sell - prices[i]);
			sell = Math.max(sell, preBuy + prices[i] - fee);
		}
		return sell;
	}
}
