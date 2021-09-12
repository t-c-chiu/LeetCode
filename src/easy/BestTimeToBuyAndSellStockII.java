package easy;

public class BestTimeToBuyAndSellStockII {
	
	public static void main(String[] args) {
//		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//		System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
//		System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
		System.out.println(maxProfit(new int[]{3, 3}));
	}
	
	public static int maxProfit(int[] prices) {
		int res = 0;
		int i = 1;
		while (i < prices.length) {
			while (i < prices.length && prices[i] <= prices[i - 1]) {
				i++;
			}
			int buy = prices[i - 1];
			while (i < prices.length && prices[i] >= prices[i - 1]) {
				i++;
			}
			int sell = prices[i - 1];
			res += sell - buy;
		}
		return res;
	}
}
