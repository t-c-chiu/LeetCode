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
		helper(nums, res, new ArrayList<>(), new boolean[nums.length]);
		return res;
	}
	
	private static void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] visited) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			temp.add(nums[i]);
			visited[i] = true;
			helper(nums, res, temp, visited);
			visited[i] = false;
			temp.remove(temp.size() - 1);
		}
	}
	
}
