package medium;

import java.util.Arrays;

public class MinimumSumOfSquaredDifference {
	
	public static void main(String[] args) {
		long res = minSumSquareDiff(new int[]{1, 4, 10, 12}, new int[]{5, 8, 6, 9}, 1, 1);
		System.out.println(res);
	}
	
	public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
		int n = nums1.length;
		int[] diff = new int[n];
		for (int i = 0; i < n; i++) {
			diff[i] = Math.abs(nums1[i] - nums2[i]);
		}
		int max = Arrays.stream(diff).max().getAsInt();
		int[] count = new int[max + 1];
		for (int i = 0; i < n; i++) {
			count[diff[i]]++;
		}
		int k = k1 + k2;
		for (int i = max; i > 0 && k > 0; i--) {
			if (count[i] > 0) {
				int minus = Math.min(k, count[i]);
				count[i] -= minus;
				count[i - 1] += minus;
				k -= minus;
			}
		}
		long res = 0;
		for (int i = 1; i <= max; i++) {
			res += (long) i * i * count[i];
		}
		return res;
	}
}
