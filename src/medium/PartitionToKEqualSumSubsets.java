package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PartitionToKEqualSumSubsets {
	
	public static void main(String[] args) {
		boolean res = canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
		System.out.println(res);
	}
	
	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % k != 0) {
			return false;
		}
		Arrays.sort(nums);
		return backtrack(nums, sum / k, k, 0, nums.length - 1, new boolean[nums.length]);
	}
	
	private static boolean backtrack(int[] nums, int target, int round, int sum, int start, boolean[] used) {
		if (round == 0) {
			return true;
		}
		if (sum == target) {
			return backtrack(nums, target, round - 1, 0, nums.length - 1, used);
		}
		for (int i = start; i >= 0; i--) {
			if (!used[i] && sum + nums[i] <= target) {
				used[i] = true;
				if (backtrack(nums, target, round, sum + nums[i], i - 1, used)) {
					return true;
				}
				used[i] = false;
			}
		}
		return false;
	}
}
