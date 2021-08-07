package medium;

import java.util.Arrays;

public class MinimumOperationsToReduceXToZero {
	
	public static void main(String[] args) {
		int res = minOperations(new int[]{1, 1, 4, 2, 3}, 5);
		System.out.println(res);
	}
	
	public static int minOperations(int[] nums, int x) {
		int n = nums.length;
		int target = Arrays.stream(nums).sum() - x;
		if (target == 0) {
			return n;
		}
		
		int left = 0;
		int sum = 0;
		int res = Integer.MAX_VALUE;
		for (int right = 0; right < n; right++) {
			sum += nums[right];
			while (sum > target && left <= right) {
				sum -= nums[left];
				left++;
			}
			if (sum == target) {
				res = Math.min(res, n - (right - left + 1));
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
}
