package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public static void main(String[] args) {
		List<List<Integer>> res = subsets(new int[]{1, 2, 3});
		System.out.println(res);
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, nums, 0, new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, int[] nums, int start, List<Integer> temp) {
		res.add(new ArrayList<>(temp));
		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			helper(res, nums, i + 1, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
