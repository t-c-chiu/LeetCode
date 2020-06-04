package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II {
	
	public static void main(String[] args) {
		Permutations_II test = new Permutations_II();
		List<List<Integer>> res = test.permuteUnique(new int[]{1, 1, 2});
		System.out.println(res);
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		permuteUnique(nums, res, new ArrayList<>(), new boolean[nums.length]);
		return res;
	}
	
	private void permuteUnique(int[] nums, List<List<Integer>> res, List<Integer> comb, boolean[] used) {
		if (comb.size() == nums.length) {
			res.add(new ArrayList<>(comb));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			comb.add(nums[i]);
			permuteUnique(nums, res, comb, used);
			used[i] = false;
			comb.remove(comb.size() - 1);
		}
	}
}
