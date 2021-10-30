package medium;

import java.util.Arrays;

public class BinarySearchableNumbersInAnUnsortedArray {
	
	public static void main(String[] args) {
		int res = binarySearchableNumbers(new int[]{-1, 5, 2});
		System.out.println(res);
	}
	
	public static int binarySearchableNumbers(int[] nums) {
		int n = nums.length;
		boolean[] searchable = new boolean[n];
		Arrays.fill(searchable, true);
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < max) {
				searchable[i] = false;
			}
			max = Math.max(max, nums[i]);
		}
		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] > min) {
				searchable[i] = false;
			}
			min = Math.min(min, nums[i]);
			if (searchable[i]) {
				res++;
			}
		}
		return res;
	}
}
