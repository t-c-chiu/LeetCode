package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public static void main(String[] args) {
		List<List<Integer>> res = combinationSum(new int[]{2, 3, 6, 7}, 7);
		System.out.println(res);
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), candidates, target, 0, 0);
		return res;
	}
	
	private static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int sum, int start) {
		if (sum == target) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (sum + candidates[i] > target) {
				return;
			}
			temp.add(candidates[i]);
			backtrack(res, temp, candidates, target, sum + candidates[i], i);
			temp.remove(temp.size() - 1);
		}
	}
}
