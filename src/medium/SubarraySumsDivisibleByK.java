package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
	
	public static void main(String[] args) {
		int res = subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
		System.out.println(res);
	}
	
	/**
	 * if sumj % k == sumi % k where j > i
	 * subarray j - i is divisible by k
	 */
	public static int subarraysDivByK(int[] nums, int k) {
		int sum = 0, res = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		for (int num : nums) {
			sum = ((sum + num) % k + k) % k;
			if (preSum.containsKey(sum)) {
				res += preSum.get(sum);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}
		return res;
	}
}
