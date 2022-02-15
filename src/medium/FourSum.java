package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
	public static void main(String[] args) {
		List<List<Integer>> res = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
		System.out.println(res);
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return kSum(nums, target, 4, 0);
	}
	
	private static List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
		if (k == 2) {
			return twoSum(nums, target, start);
		} else {
			List<List<Integer>> res = new ArrayList<>();
			for (int i = start; i < nums.length; i++) {
				if (i > start && nums[i] == nums[i - 1]) {
					continue;
				}
				List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
				if (!temp.isEmpty()) {
					for (List<Integer> list : temp) {
						list.add(0, nums[i]);
					}
					res.addAll(temp);
				}
			}
			return res;
		}
	}
	
	private static List<List<Integer>> twoSum(int[] nums, int target, int start) {
		List<List<Integer>> res = new ArrayList<>();
		int l = start, r = nums.length - 1;
		while (l < r) {
			int sum = nums[l] + nums[r];
			if (sum == target) {
				List<Integer> list = new ArrayList<>();
				list.add(nums[l]);
				list.add(nums[r]);
				res.add(list);
				l++;
				r--;
				while (l < r && nums[l] == nums[l - 1]) {
					l++;
				}
				while (l < r && nums[r] == nums[r + 1]) {
					r--;
				}
			} else if (sum < target) {
				l++;
			} else {
				r--;
			}
		}
		return res;
	}
}
