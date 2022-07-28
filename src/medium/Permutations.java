package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
	
	public static void main(String[] args) {
		List<List<Integer>> res = permute(new int[]{1, 2, 3});
		System.out.println(res);
	}
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, nums, new ArrayList<>(), new HashSet<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, int[] nums, List<Integer> temp, Set<Integer> seen) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int num : nums) {
			if (seen.contains(num)) {
				continue;
			}
			temp.add(num);
			seen.add(num);
			helper(res, nums, temp, seen);
			seen.remove(num);
			temp.remove(temp.size() - 1);
		}
	}
	
}
