package medium;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	
	public static void main(String[] args) {
		System.out.println(canPartition(new int[]{1, 5, 11, 5}));
	}
	
	public static boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		if (sum % 2 == 1) {
			return false;
		}
		sum /= 2;
		int n = nums.length;
		boolean[][] dp = new boolean[n + 1][sum + 1];
		dp[0][0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				int num = nums[i - 1];
				if (j >= num && dp[i - 1][j - num]) {
					dp[i][j] = true;
				}
			}
		}
		return dp[n][sum];
	}
}
