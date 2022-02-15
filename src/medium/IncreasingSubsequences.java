package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
	
	public static void main(String[] args) {
		List<List<Integer>> res = findSubsequences(new int[]{4, 6, 7, 7});
		System.out.println(res);
	}
	
	public static List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backTracking(res, nums, 0, new ArrayList<>());
		return res;
	}
	
	private static void backTracking(List<List<Integer>> res, int[] nums, int start, List<Integer> temp) {
		if (temp.size() > 1) {
			res.add(new ArrayList<>(temp));
		}
		Set<Integer> used = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			if (used.contains(nums[i])) {
				continue;
			}
			if (temp.isEmpty() || nums[i] >= temp.get(temp.size() - 1)) {
				used.add(nums[i]);
				temp.add(nums[i]);
				backTracking(res, nums, i + 1, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
