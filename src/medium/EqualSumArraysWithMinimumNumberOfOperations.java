package medium;

import java.util.Arrays;

public class EqualSumArraysWithMinimumNumberOfOperations {
	
	public static void main(String[] args) {
		int res = minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2});
		System.out.println(res);
	}
	
	public static int minOperations(int[] nums1, int[] nums2) {
		if (nums1.length * 6 < nums2.length || nums1.length > nums2.length * 6) {
			return -1;
		}
		int sum1 = Arrays.stream(nums1).sum();
		int sum2 = Arrays.stream(nums2).sum();
		if (sum1 > sum2) {
			return minOperations(nums2, nums1);
		}
		
		int[] count = new int[6];
		for (int i : nums1) {
			count[6 - i]++;
		}
		for (int i : nums2) {
			count[i - 1]++;
		}
		
		int i = 5, res = 0;
		while (sum1 < sum2) {
			if (count[i] == 0) {
				i--;
			}
			sum1 += i;
			count[i]--;
			res++;
		}
		return res;
	}
}
