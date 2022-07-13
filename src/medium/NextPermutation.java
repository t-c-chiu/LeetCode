package medium;

import java.util.Arrays;

public class NextPermutation {
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 1};
		nextPermutation(arr);
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
	}
	
	/**
	 * 1 3 4 2 5 - 1 3 4 5 2 - 1 3 5 2 4 - 1 3 5 4 2
	 * 1 4 2 3 5 - 1 4 2 5 3 - 1 4 3 2 5 - 1 4 3 5 2
	 */
	public static void nextPermutation(int[] nums) {
		int n = nums.length, i = n - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = n - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}
	
	private static void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
	private static void reverse(int[] nums, int start) {
		int end = nums.length - 1;
		while (start < end) {
			swap(nums, start++, end--);
		}
	}
	
}
