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
		backtrack(res, new ArrayList<>(), nums);
		return res;
	}
	
	private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i])) {
				continue;
			}
			temp.add(nums[i]);
			backtrack(res, temp, nums);
			temp.remove(temp.size() - 1);
		}
	}
}
