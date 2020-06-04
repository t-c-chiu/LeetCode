package medium;

import java.util.*;

public class Combination_Sum_II {
	
	public static void main(String[] args) {
		Combination_Sum_II test = new Combination_Sum_II();
		List<List<Integer>> res = test.combinationSum2(new int[]{1, 1, 1, 1, 2, 2}, 6);
		System.out.println(res);
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		combinationSum2(candidates, target, res, new ArrayList<>(), 0);
		return res;
	}
	
	private void combinationSum2(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int start) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		
		for (int i = start; i < candidates.length; i++) {
			int candidate = candidates[i];
			if (i > start && candidate == candidates[i - 1]) {
				continue;
			}
			temp.add(candidate);
			combinationSum2(candidates, target - candidate, res, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
