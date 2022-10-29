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
		helper(res, nums, 0, new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, int[] nums, int start, List<Integer> temp) {
		res.add(new ArrayList<>(temp));
		if (start == nums.length) {
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			helper(res, nums, i + 1, temp);
			temp.remove(temp.size() - 1);
		}
	}
	
}
