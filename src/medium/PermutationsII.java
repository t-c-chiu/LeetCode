package medium;

import java.util.*;

public class PermutationsII {
	
	public static void main(String[] args) {
		List<List<Integer>> res = permuteUnique(new int[]{1, 1, 2});
		System.out.println(res);
	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		helper(res, nums, new boolean[nums.length], new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> temp) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			temp.add(nums[i]);
			helper(res, nums, used, temp);
			used[i] = false;
			temp.remove(temp.size() - 1);
		}
	}
}
