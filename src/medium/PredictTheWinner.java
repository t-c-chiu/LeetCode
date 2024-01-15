package medium;

import java.util.Arrays;

public class PredictTheWinner {
	
	public static void main(String[] args) {
		boolean res = predictTheWinner(new int[]{1, 5, 233, 7});
		System.out.println(res);
	}
	
	public static boolean predictTheWinner(int[] nums) {
		int n = nums.length;
		int[][] memo = new int[n][n];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}
		int firstScore = helper(nums, 0, n - 1, memo);
		int totalScore = 0;
		for (int num : nums) {
			totalScore += num;
		}
		return firstScore >= totalScore - firstScore;
	}
	
	private static int helper(int[] nums, int i, int j, int[][] memo) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return nums[i];
		}
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
		memo[i][j] = Math.max(
				nums[i] + Math.min(helper(nums, i + 2, j, memo), helper(nums, i + 1, j - 1, memo)),
				nums[j] + Math.min(helper(nums, i, j - 2, memo), helper(nums, i + 1, j - 1, memo)));
		return memo[i][j];
	}
	
}
