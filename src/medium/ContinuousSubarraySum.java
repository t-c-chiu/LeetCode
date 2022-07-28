package medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	
	public static void main(String[] args) {
		boolean res = checkSubarraySum(new int[]{1, 2, 12}, 6);
		System.out.println(res);
	}
	
	/**
	 * 5, 1, 5,
	 */
	public static boolean checkSubarraySum(int[] nums, int k) {
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int mod = sum % k;
			if (map.containsKey(mod) && i - map.get(mod) > 1) {
				return true;
			}
			map.putIfAbsent(mod, i);
		}
		return false;
	}
}
