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
		backtrack(res, new ArrayList<>(), nums, 0);
		return res;
	}
	
	private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
		res.add(new ArrayList<>(temp));
		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			backtrack(res, temp, nums, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
