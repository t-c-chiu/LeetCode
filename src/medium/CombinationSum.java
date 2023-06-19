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
		helper(res, candidates, target, 0, 0, new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, int[] candidates, int target, int start, int sum, List<Integer> temp) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			temp.add(candidates[i]);
			helper(res, candidates, target, i, sum + candidates[i], temp);
			temp.remove(temp.size() - 1);
		}
	}
}
