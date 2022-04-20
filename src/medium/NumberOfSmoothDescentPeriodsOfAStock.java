package medium;

public class NumberOfSmoothDescentPeriodsOfAStock {
	
	public static void main(String[] args) {
		long res = getDescentPeriods(new int[]{3, 2, 1, 4});
		System.out.println(res);
	}
	
	public static long getDescentPeriods(int[] prices) {
		long res = 1, count = 1;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] == prices[i - 1] - 1) {
				count++;
			} else {
				count = 1;
			}
			res += count;
		}
		return res;
	}
	
//	public static long getDescentPeriods(int[] prices) {
//		long res = 0;
//		int n = prices.length;
//		int[] dp = new int[n];
//		Arrays.fill(dp, 1);
//		for (int i = 1; i < n; i++) {
//			if (prices[i] == prices[i - 1] - 1) {
//				dp[i] = dp[i - 1] + 1;
//			}
//		}
//		for (int i : dp) {
//			res += i;
//		}
//		return res;
//	}
}
