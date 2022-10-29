package medium;

import java.util.*;

public class CombinationSumII {
	
	public static void main(String[] args) {
		List<List<Integer>> res = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
		System.out.println(res);
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		helper(res, candidates, 0, target, new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, int[] candidates, int start, int target, List<Integer> temp) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			temp.add(candidates[i]);
			helper(res, candidates, i + 1, target - candidates[i], temp);
			temp.remove(temp.size() - 1);
		}
	}
	
}
