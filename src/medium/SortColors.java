package medium;

import java.util.Arrays;

public class SortColors {
	
	public static void main(String[] args) {
		int[] nums = new int[]{2, 0, 2, 1, 1, 0};
		sortColors(nums);
		Arrays.stream(nums).forEach(System.out::print);
	}
	
	public static void sortColors(int[] nums) {
		int n = nums.length, i = 0, l = 0, r = n - 1;
		while (i <= r) {
			int num = nums[i];
			if (num == 0) {
				swap(nums, i, l);
				i++;
				l++;
			} else if (num == 2) {
				swap(nums, i, r);
				r--;
			} else {
				i++;
			}
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
}
