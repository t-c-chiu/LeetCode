package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public static void main(String[] args) {
		CombinationSum test = new CombinationSum();
		System.out.println(test.combinationSum(new int[]{2, 3, 6, 7}, 7));
		System.out.println(test.combinationSum(new int[]{2, 3, 5}, 8));
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}
	
	private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			res.add(new ArrayList<>(tmp));
		else {
			for (int i = start; i < candidates.length; i++) {
				tmp.add(candidates[i]);
				backtrack(res, tmp, candidates, remain - candidates[i], i);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
