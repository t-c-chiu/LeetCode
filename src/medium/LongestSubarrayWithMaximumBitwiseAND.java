package medium;

import java.util.Arrays;

public class LongestSubarrayWithMaximumBitwiseAND {
	
	public static void main(String[] args) {
		int res = longestSubarray(new int[]{1, 2, 3, 4});
		System.out.println(res);
	}
	
	public static int longestSubarray(int[] nums) {
		int max = Arrays.stream(nums).max().getAsInt(), res = 0, len = 0;
		for (int num : nums) {
			if (num == max) {
				len++;
				res = Math.max(res, len);
			} else {
				len = 0;
			}
		}
		return res;
	}
}
