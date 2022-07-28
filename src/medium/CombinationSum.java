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
		helper(res, candidates, 0, 0, target, new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, int[] candidates, int start, int sum, int target, List<Integer> temp) {
		if (sum == target) {
			res.add(new ArrayList<>(temp));
			return;
		}
		if (sum > target) {
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			temp.add(candidates[i]);
			helper(res, candidates, i, sum + candidates[i], target, temp);
			temp.remove(temp.size() - 1);
		}
	}
	
}
