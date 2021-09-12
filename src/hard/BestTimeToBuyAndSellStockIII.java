package hard;

public class BestTimeToBuyAndSellStockIII {
	
	public static void main(String[] args) {
		int res = maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0});
		System.out.println(res);
	}
	
	public static int maxProfit(int[] prices) {
		int n = prices.length;
		int[] leftProfit = new int[n];
		int[] rightProfit = new int[n + 1];
		int leftMin = prices[0];
		int rightMax = prices[n - 1];
		for (int i = 1; i < n; i++) {
			leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - leftMin);
			leftMin = Math.min(leftMin, prices[i]);
		}
		for (int i = n - 2; i >= 0; i--) {
			rightProfit[i] = Math.max(rightProfit[i + 1], rightMax - prices[i]);
			rightMax = Math.max(rightMax, prices[i]);
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, leftProfit[i] + rightProfit[i + 1]);
		}
		return res;
	}
}
