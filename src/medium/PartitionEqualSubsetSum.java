package medium;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	
	public static void main(String[] args) {
		System.out.println(canPartition(new int[]{1, 5, 11, 5}));
	}
	
	public static boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum(), n = nums.length;
		if (sum % 2 == 1) {
			return false;
		}
		sum /= 2;
		boolean[][] dp = new boolean[n + 1][sum + 1];
		dp[0][0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= nums[i - 1]) {
					dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
				}
			}
		}
		return dp[n][sum];
	}
}
