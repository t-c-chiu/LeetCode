package medium;

import java.util.Arrays;

public class LongestNondecreasingSubarrayFromTwoArrays {
	
	public static void main(String[] args) {
		int res = maxNonDecreasingLength(new int[]{2, 3, 1}, new int[]{1, 2, 1});
		System.out.println(res);
	}
	
	public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
		int n = nums1.length, res = 1;
		int[][] dp = new int[n][2];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], 1);
		}
		for (int i = 1; i < n; i++) {
			int n1 = nums1[i], n2 = nums2[i], prevN1 = nums1[i - 1], prevN2 = nums2[i - 1];
			if (n1 >= prevN1) {
				dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + 1);
			}
			if (n1 >= prevN2) {
				dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
			}
			if (n2 >= prevN1) {
				dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
			}
			if (n2 >= prevN2) {
				dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] + 1);
			}
			res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
		}
		return res;
	}
	
}
