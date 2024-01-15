package medium;

import java.util.Arrays;

public class KRadiusSubarrayAverages {
	
	public static void main(String[] args) {
		int[] res = getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] getAverages(int[] nums, int k) {
		int n = nums.length, count = k * 2 + 1;
		long sum = 0;
		int[] res = new int[n];
		Arrays.fill(res, -1);
		for (int left = 0, right = 0; right < n; right++) {
			sum += nums[right];
			if (right - left + 1 == count) {
				res[right - k] = (int) (sum / count);
				sum -= nums[left++];
			}
		}
		return res;
	}
}
