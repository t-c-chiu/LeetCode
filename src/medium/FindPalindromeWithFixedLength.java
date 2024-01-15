package medium;

import java.util.Arrays;

public class FindPalindromeWithFixedLength {
	
	public static void main(String[] args) {
//		long[] res = kthPalindrome(new int[]{1, 2, 3, 4, 5, 90}, 3);
		long[] res = kthPalindrome(new int[]{2, 4, 6}, 4);
		System.out.println(Arrays.toString(res));
	}
	
	/**
	 * 1 ~ 9 - 9
	 * 11 ~ 99 - 9
	 * 101 ~ 999 - 9 * 10 = 90
	 * 1001 ~ 9999 - 9 * 10 = 90
	 * 10001 ~ 99999 = 90 * 10 = 900
	 */
	public static long[] kthPalindrome(int[] queries, int intLength) {
		long base = (long) Math.pow(10, (intLength - 1) / 2), max = base * 9;
		int n = queries.length;
		long[] res = new long[n];
		for (int i = 0; i < n; i++) {
			if (queries[i] > max) {
				res[i] = -1;
			} else {
				String front = String.valueOf(base + queries[i] - 1);
				if (intLength % 2 == 0) {
					res[i] = Long.parseLong(front + new StringBuilder(front).reverse());
				} else {
					res[i] = Long.parseLong(front + new StringBuilder(front.substring(0, front.length() - 1)).reverse());
				}
			}
		}
		return res;
	}
	
}
