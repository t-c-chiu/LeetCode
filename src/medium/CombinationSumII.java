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
		helper(res, candidates, 0, 0, target, new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, int[] arr, int start, int sum, int target, List<Integer> temp) {
		if (sum == target) {
			res.add(new ArrayList<>(temp));
			return;
		}
		if (sum > target) {
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if (i > start && arr[i] == arr[i - 1]) {
				continue;
			}
			temp.add(arr[i]);
			helper(res, arr, i + 1, sum + arr[i], target, temp);
			temp.remove(temp.size() - 1);
		}
	}
	
	
}
