package medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
	
	public static void main(String[] args) {
		int res = maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
		System.out.println(res);
	}
	
	// 1 0 5 3 6
	public static int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				res = Math.max(res, i - map.get(sum - k));
			}
			map.putIfAbsent(sum, i);
		}
		return res;
	}
}
