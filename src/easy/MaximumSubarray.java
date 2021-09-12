package easy;

public class MaximumSubarray {
	public static void main(String[] args) {
		int res = maxSubArray(new int[]{1});
		System.out.println(res);
	}
	
	public static int maxSubArray(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		int res = dp[0];
		for (int i = 1; i < n; i++) {
			dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	
}
