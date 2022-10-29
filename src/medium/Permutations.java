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
		helper(res, nums, new HashSet<>(), new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, int[] nums, Set<Integer> seen, List<Integer> temp) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int num : nums) {
			if (seen.contains(num)) {
				continue;
			}
			seen.add(num);
			temp.add(num);
			helper(res, nums, seen, temp);
			temp.remove(temp.size() - 1);
			seen.remove(num);
		}
	}
}
