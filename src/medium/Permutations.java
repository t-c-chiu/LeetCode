package medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static void main(String[] args) {
		List<List<Integer>> res = permute(new int[]{1, 2, 3});
		System.out.println(res);
	}
	
	public static List<List<Integer>> permute(int[] nums) {
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
			if (used[i]) {
				continue;
			}
			used[i] = true;
			temp.add(nums[i]);
			helper(res, nums, used, temp);
			temp.remove(temp.size() - 1);
			used[i] = false;
		}
	}
}
