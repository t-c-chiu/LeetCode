package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumANDSumOfArray {
	
	public static void main(String[] args) {
		int res = maximumANDSum(new int[]{1, 2, 3, 4, 5, 6}, 3);
		System.out.println(res);
	}
	
	
	public static int maximumANDSum(int[] nums, int numSlots) {
		int[] slots = new int[numSlots + 1];
		for (int i = 1; i <= numSlots; i++) {
			slots[i] = 2;
		}
		Map<String, Integer> memo = new HashMap<>();
		return dfs(nums, slots, 0, memo);
	}
	
	private static int dfs(int[] nums, int[] slots, int i, Map<String, Integer> memo) {
		if (i == nums.length) {
			return 0;
		}
		String key = Arrays.toString(slots) + "," + i;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		int max = Integer.MIN_VALUE;
		for (int j = 1; j < slots.length; j++) {
			if (slots[j] > 0) {
				slots[j]--;
				max = Math.max(max, (nums[i] & j) + dfs(nums, slots, i + 1, memo));
				slots[j]++;
			}
		}
		memo.put(key, max);
		return max;
	}
}
