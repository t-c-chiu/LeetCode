package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	public static void main(String[] args) {
		List<List<Integer>> res = combinationSum(new int[]{2, 3, 6, 7}, 7);
		System.out.println(res);
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		helper(candidates, target, res, new ArrayList<>(), 0, 0);
		return res;
	}
	
	private static void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int sum, int start) {
		if (sum == target) {
			res.add(new ArrayList<>(temp));
			return;
		}
		if (sum > target) {
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			temp.add(candidates[i]);
			helper(candidates, target, res, temp, sum + candidates[i], i);
			temp.remove(temp.size() - 1);
		}
	}
	
	
}
