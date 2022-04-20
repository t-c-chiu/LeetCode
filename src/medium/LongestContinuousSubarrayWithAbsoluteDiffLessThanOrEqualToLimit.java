package medium;

import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
	
	public static void main(String[] args) {
		int res = longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5);
		System.out.println(res);
	}
	
	public static int longestSubarray(int[] nums, int limit) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		int res = 0, l = 0;
		for (int r = 0; r < nums.length; r++) {
			treeMap.put(nums[r], treeMap.getOrDefault(nums[r], 0) + 1);
			while (treeMap.lastKey() - treeMap.firstKey() > limit) {
				treeMap.put(nums[l], treeMap.getOrDefault(nums[l], 0) - 1);
				treeMap.remove(nums[l], 0);
				l++;
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
	
}
