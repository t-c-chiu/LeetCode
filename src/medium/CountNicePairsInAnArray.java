package medium;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray {
	
	public static void main(String[] args) {
		int res = countNicePairs(new int[]{42, 11, 1, 97});
		System.out.println(res);
	}
	
	/**
	 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
	 * nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
	 */
	public static int countNicePairs(int[] nums) {
		int res = 0, mod = (int) 1e9 + 7;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			num -= rev(num);
			Integer count = map.getOrDefault(num, 0);
			res = (res + count) % mod;
			map.put(num, count + 1);
		}
		return res;
	}
	
	private static int rev(int num) {
		int res = 0;
		while (num > 0) {
			res = res * 10 + num % 10;
			num /= 10;
		}
		return res;
	}
}
