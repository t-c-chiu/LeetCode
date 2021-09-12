package medium;

public class MaximumSubarraySumAfterOneOperation {
	
	public static void main(String[] args) {
		int res = maxSumAfterOperation(new int[]{1, -1, 1, 1, -1, -1, 1});
		System.out.println(res);
	}
	
	public static int maxSumAfterOperation(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][2];
		// dp[i][0] is the max subarray
		// dp[i][1] is the max subarray after squaring one number
		dp[0][0] = nums[0];
		dp[0][1] = nums[0] * nums[0];
		int res = dp[0][1];
		for (int i = 1; i < n; i++) {
			int num = nums[i];
			dp[i][0] = num + Math.max(0, dp[i - 1][0]);
			int squareThis = num * num + Math.max(0, dp[i - 1][0]);
			int notSquareThis = num + dp[i - 1][1];
			dp[i][1] = Math.max(squareThis, notSquareThis);
			res = Math.max(res, dp[i][1]);
		}
		return res;
	}
}
