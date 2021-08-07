package medium;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
	
	public static void main(String[] args) {
		int res = maxFrequency(new int[]{1, 4, 8, 13}, 5);
		System.out.println(res);
	}
	
	public static int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
		int left = 0;
		int res = 1;
		long sum = 0;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (sum + k < (right - left + 1) * (long) nums[right]) {
				sum -= nums[left];
				left++;
			}
			res = Math.max(res, right - left + 1);
		}
		return res;
	}
}
