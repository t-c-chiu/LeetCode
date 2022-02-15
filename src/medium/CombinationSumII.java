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
		backtrack(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}
	
	private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start) {
		if (target == 0) {
			res.add(new ArrayList<>(temp));
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			if (target - candidates[i] < 0) {
				return;
			}
			temp.add(candidates[i]);
			backtrack(res, temp, candidates, target - candidates[i], i + 1);
			temp.remove(temp.size() - 1);
		}
	}
	
}
