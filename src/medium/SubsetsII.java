package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public static void main(String[] args) {
		List<List<Integer>> res = subsetsWithDup(new int[]{1, 2, 2});
		System.out.println(res);
	}
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), nums, 0);
		return res;
	}
	
	private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
		res.add(new ArrayList<>(temp));
		for (int i = start; i < nums.length; i++) {
			if (i == start || nums[i] != nums[i - 1]) {
				temp.add(nums[i]);
				backtrack(res, temp, nums, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
}
