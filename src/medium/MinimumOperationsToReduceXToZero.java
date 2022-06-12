package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {
	
	public static void main(String[] args) {
		int res = minOperations(new int[]{1, 1, 4, 2, 3}, 5);
		System.out.println(res);
	}
	
	public static int minOperations(int[] nums, int x) {
		int target = Arrays.stream(nums).sum() - x;
		if (target == 0) {
			return nums.length;
		}
		int sum = 0;
		int res = -1;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - target)) {
				res = Math.max(res, i - preSum.get(sum - target));
			}
			preSum.put(sum, i);
		}
		return res == -1 ? -1 : nums.length - res;
	}
}
