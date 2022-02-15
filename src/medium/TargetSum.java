package medium;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
	
	public static void main(String[] args) {
		int res = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
		System.out.println(res);
	}
	
	public static int findTargetSumWays(int[] nums, int target) {
		Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
		return backtrack(nums, target, 0, 0, memo);
	}
	
	private static int backtrack(int[] nums, int target, int i, int sum, Map<Integer, Map<Integer, Integer>> memo) {
		if (i == nums.length) {
			return sum == target ? 1 : 0;
		}
		if (memo.containsKey(i) && memo.get(i).containsKey(sum)) {
			return memo.get(i).get(sum);
		}
		int add = backtrack(nums, target, i + 1, sum - nums[i], memo);
		int subtract = backtrack(nums, target, i + 1, sum + nums[i], memo);
		memo.putIfAbsent(i, new HashMap<>());
		memo.get(i).put(sum, add + subtract);
		return add + subtract;
	}
}
