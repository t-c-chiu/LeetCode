package medium;

import java.util.Arrays;

public class SumOfAbsoluteDifferencesInASortedArray {
	
	public static void main(String[] args) {
		int[] res = getSumAbsoluteDifferences(new int[]{2, 3, 5});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] getSumAbsoluteDifferences(int[] nums) {
		int n = nums.length;
		int[] preSum = new int[n];
		preSum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			preSum[i] = preSum[i - 1] + nums[i];
		}
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			int left = nums[i] * (i + 1) - preSum[i];
			int right = preSum[n - 1] - (i > 0 ? preSum[i - 1] : 0) - nums[i] * (n - i);
			res[i] = left + right;
		}
		return res;
	}
}
