package medium;

public class MaximumNumberThatSumOfThePricesIsLessThanOrEqualToK {
	
	public static void main(String[] args) {
		long res = findMaximumNumber(9, 1);
		System.out.println(res);
	}
	
	/**
	 * 1, 10, 11, 100, 101, 110, 111, 1000, 1001
	 */
	public static long findMaximumNumber(long k, int x) {
		long res = 1, prices = 0;
		while (prices <= k) {
			String binaryString = Long.toBinaryString(res);
			int temp = x, price = 0, n = binaryString.length();
			while (temp <= n) {
				if (binaryString.charAt(n - temp) == '1') {
					price++;
				}
				temp += x;
			}
			prices += price;
			if (prices > k) {
				return res - 1;
			}
			res++;
		}
		return -1;
	}
}
