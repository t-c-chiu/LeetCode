package medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	
	public static void main(String[] args) {
		boolean res = checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
		System.out.println(res);
	}
	
	public static boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
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
