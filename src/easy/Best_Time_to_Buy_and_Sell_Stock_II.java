package easy;

public class Best_Time_to_Buy_and_Sell_Stock_II {
	
	public static void main(String[] args) {
		Best_Time_to_Buy_and_Sell_Stock_II test = new Best_Time_to_Buy_and_Sell_Stock_II();
		System.out.println(test.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(test.maxProfit(new int[]{1, 2, 3, 4, 5}));
		System.out.println(test.maxProfit(new int[]{7, 6, 4, 3, 1}));
	}
	
	public int maxProfit(int[] prices) {
		int profit = 0, i = 0, len = prices.length;
		while (i < len) {
			while (i < len - 1 && prices[i + 1] < prices[i])
				i++;
			int min = prices[i++];
			while (i < len - 1 && prices[i + 1] > prices[i])
				i++;
			profit += i < len ? prices[i++] - min : 0;
		}
		return profit;
	}
}
