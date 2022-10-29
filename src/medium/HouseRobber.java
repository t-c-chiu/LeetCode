package medium;

public class HouseRobber {
	
	public static void main(String[] args) {
		int res = rob(new int[]{-2, 7, 9, 4, 1});
		System.out.println(res);
	}
	
	public static int rob(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = Math.max(0, nums[0]);
		dp[1] = Math.max(dp[0], nums[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + Math.max(0, nums[i]));
		}
		return dp[n - 1];
	}
}
