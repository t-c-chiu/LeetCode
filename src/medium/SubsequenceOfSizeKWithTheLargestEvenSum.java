package medium;

import java.util.Arrays;

public class SubsequenceOfSizeKWithTheLargestEvenSum {
	
	public static void main(String[] args) {
		long res = largestEvenSum(new int[]{8, 3, 3, 17, 4, 8}, 3);
		System.out.println(res);
	}
	
	public static long largestEvenSum(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length, minOdd = -1, minEven = -1;
		long sum = 0;
		for (int i = n - 1; i >= n - k; i--) {
			int num = nums[i];
			if (num % 2 == 1) {
				minOdd = num;
			}
			if (num % 2 == 0) {
				minEven = num;
			}
			sum += num;
		}
		if (sum % 2 == 0) {
			return sum;
		}
		int maxOdd = -1, maxEven = -1;
		for (int i = 0; i < n - k; i++) {
			if (nums[i] % 2 == 0) {
				maxEven = nums[i];
			} else {
				maxOdd = nums[i];
			}
		}
		long res = -1;
		if (maxOdd != -1 && minEven != -1) {
			res = Math.max(res, sum + maxOdd - minEven);
		}
		if (maxEven != -1 && minOdd != -1) {
			res = Math.max(res, sum + maxEven - minOdd);
		}
		return res;
	}
}
