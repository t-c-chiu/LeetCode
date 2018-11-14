package easy;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
		System.out.println(test.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(test.maxProfit(new int[]{7, 6, 4, 3, 1}));
	}

	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;

		int min = prices[0];
		int result = 0;
		for (int i : prices) {
			if (i < min)
				min = i;
			else {
				int temp = i - min;
				if (temp > result)
					result = temp;
			}
		}
		return result;
	}
}
