package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInAnArray {
	
	public static void main(String[] args) {
		int res = findPairs(new int[]{3, 1, 4, 1, 5}, 2);
		System.out.println(res);
	}
	
	public static int findPairs(int[] nums, int k) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int key : map.keySet()) {
			if (k == 0 && map.get(key) > 1 || k > 0 && map.containsKey(key + k)) {
				res++;
			}
		}
		return res;
	}
	
//	public static int findPairs(int[] nums, int k) {
//		Arrays.sort(nums);
//		int res = 0, slow = 0, fast = 1, n = nums.length;
//		while (fast < n) {
//			int diff = nums[fast] - nums[slow];
//			if (diff <= k) {
//				if (diff == k) {
//					res++;
//				}
//				fast++;
//				while (fast < n && nums[fast - 1] == nums[fast]) {
//					fast++;
//				}
//			} else {
//				slow++;
//				while (slow < fast && nums[slow - 1] == nums[slow]) {
//					slow++;
//				}
//				if (slow == fast) {
//					fast++;
//				}
//			}
//		}
//		return res;
//	}
}
