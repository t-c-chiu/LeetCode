package medium;

import java.util.Arrays;

public class MaximumNumberOfJumpsToReachTheLastIndex {
	
	public static void main(String[] args) {
		int res = maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 3);
		System.out.println(res);
	}
	
	public static int maximumJumps(int[] nums, int target) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(nums[j] - nums[i]) <= target && dp[i] != -1) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
				}
			}
		}
		return dp[n - 1];
	}
	
	
}
