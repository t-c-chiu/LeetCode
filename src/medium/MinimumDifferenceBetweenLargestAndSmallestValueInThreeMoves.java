package medium;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
	
	public static void main(String[] args) {
		int res = minDifference(new int[]{1, 5, 6, 14, 15});
		System.out.println(res);
	}
	
	public static int minDifference(int[] nums) {
		int n = nums.length, res = Integer.MAX_VALUE;
		if (n <= 4) {
			return 0;
		}
		Arrays.sort(nums);
		for (int i = 0; i <= 3; i++) {
			res = Math.min(res, nums[n - 4 + i] - nums[i]);
		}
		return res;
	}
}
