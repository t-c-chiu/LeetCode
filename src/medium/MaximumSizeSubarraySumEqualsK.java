package medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
	
	public static void main(String[] args) {
		int res = maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
		System.out.println(res);
	}
	
	public static int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int res = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			map.putIfAbsent(sum, i);
			if (map.containsKey(sum - k)) {
				res = Math.max(res, i - map.get(sum - k));
			}
		}
		return res;
	}
}
