package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	public static void main(String[] args) {
		int res = subarraySum(new int[]{1, 1, 1}, 2);
		System.out.println(res);
	}
	
	public static int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		int sum = 0, res = 0;
		for (int num : nums) {
			sum += num;
			if (preSum.containsKey(sum - k)) {
				res += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}
		return res;
	}
}
