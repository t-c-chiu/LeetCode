package medium;

import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
	
	public static void main(String[] args) {
		int res = longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5);
		System.out.println(res);
	}
	
	public static int longestSubarray(int[] nums, int limit) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int res = 0;
		for (int r = 0, l = 0; r < nums.length; r++) {
			map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
			while (map.lastKey() - map.firstKey() > limit) {
				map.put(nums[l], map.get(nums[l]) - 1);
				map.remove(nums[l], 0);
				l++;
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
	
}
