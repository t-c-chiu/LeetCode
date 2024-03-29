package easy;

public class BestTimeToBuyAndSellStock {
	
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
	}
	
	public static int maxProfit(int[] prices) {
		int res = 0, min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			res = Math.max(res, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return res;
	}
}
