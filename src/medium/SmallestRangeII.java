package medium;

import java.util.Arrays;

public class SmallestRangeII {
	
	public static void main(String[] args) {
		int res = smallestRangeII(new int[]{7, 8, 8}, 5);
		System.out.println(res);
	}
	
	public static int smallestRangeII(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length, min = nums[0], max = nums[n - 1], res = max - min;
		for (int i = 0; i < n - 1; i++) {
			min = Math.min(nums[0] + k, nums[i + 1] - k);
			max = Math.max(nums[n - 1] - k, nums[i] + k);
			res = Math.min(res, max - min);
		}
		return res;
	}
}
