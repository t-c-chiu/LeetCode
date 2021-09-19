package medium;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
	
	public static void main(String[] args) {
		int res = numSubseq(new int[]{5, 2, 4, 1, 7, 6, 8}, 16);
		System.out.println(res);
	}
	
	public static int numSubseq(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length, left = 0, right = n - 1, res = 0, mod = (int) Math.pow(10, 9) + 7;
		int[] pow = new int[n];
		pow[0] = 1;
		for (int i = 1; i < n; i++) {
			pow[i] = pow[i - 1] * 2 % mod;
		}
		while (left <= right) {
			while (left <= right && nums[left] + nums[right] > target) {
				right--;
			}
			if (left <= right) {
				res += pow[right - left];
				res %= mod;
			}
			left++;
		}
		return res;
	}
}
