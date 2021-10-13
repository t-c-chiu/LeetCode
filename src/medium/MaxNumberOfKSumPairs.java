package medium;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
	
	public static void main(String[] args) {
		int res = maxOperations(new int[]{1,2,3,4}, 5);
		System.out.println(res);
	}
	
	public static int maxOperations(int[] nums, int k) {
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1, res = 0;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == k) {
				res++;
				left++;
				right--;
			} else if (sum < k) {
				left++;
			} else {
				right--;
			}
		}
		return res;
	}
}
