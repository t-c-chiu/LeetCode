package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
	public static void main(String[] args) {
		List<List<Integer>> res = fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
		System.out.println(res);
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return kSum(nums, target, 0, 4);
	}
	
	private static List<List<Integer>> kSum(int[] nums, int target, int i, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (i >= nums.length) {
			return res;
		}
		if (k == 2) {
			return twoSum(nums, target, i);
		}
		for (int j = i; j < nums.length; j++) {
			if (j == i || nums[j] != nums[j - 1]) {
				List<List<Integer>> tmp = kSum(nums, target - nums[j], j + 1, k - 1);
				for (List<Integer> l : tmp) {
					l.add(0, nums[j]);
				}
				res.addAll(tmp);
			}
		}
		return res;
	}
	
	private static List<List<Integer>> twoSum(int[] nums, int target, int i) {
		List<List<Integer>> res = new ArrayList<>();
		int j = nums.length - 1;
		while (i < j) {
			int num1 = nums[i];
			int num2 = nums[j];
			if (num1 + num2 == target) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(num1);
				tmp.add(num2);
				res.add(tmp);
				i++;
				j--;
				while (i < j && nums[i] == nums[i - 1]) i++;
				while (i < j && nums[j] == nums[j + 1]) j--;
			} else if (num1 + num2 < target) {
				i++;
			} else {
				j--;
			}
		}
		return res;
	}
}
