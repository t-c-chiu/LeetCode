package medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int res = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
		System.out.println(res);
	}
	
	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
