package medium;

public class MaximumScoreFromPerformingMultiplicationOperations {
	
	public static void main(String[] args) {
		int res = maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1});
		System.out.println(res);
	}
	
	
	public static int maximumScore(int[] nums, int[] multipliers) {
		int m = multipliers.length;
		return helper(nums, 0, nums.length - 1, multipliers, 0, new Integer[m][m]);
	}
	
	private static int helper(int[] nums, int left, int right, int[] multipliers, int i, Integer[][] memo) {
		if (i == multipliers.length) {
			return 0;
		}
		if (memo[i][left] != null) {
			return memo[i][left];
		}
		int pickLeft = helper(nums, left + 1, right, multipliers, i + 1, memo) + multipliers[i] * nums[left];
		int pickRight = helper(nums, left, right - 1, multipliers, i + 1, memo) + multipliers[i] * nums[right];
		return memo[i][left] = Math.max(pickLeft, pickRight);
	}
}
