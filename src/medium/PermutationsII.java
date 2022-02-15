package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	
	public static void main(String[] args) {
		List<List<Integer>> res = permuteUnique(new int[]{1, 1, 2});
		System.out.println(res);
	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
		return res;
	}
	
	private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
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
			backtrack(res, temp, nums, used);
			temp.remove(temp.size() - 1);
			used[i] = false;
		}
	}
}
