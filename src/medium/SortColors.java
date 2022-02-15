package medium;

import java.util.Arrays;

public class SortColors {
	
	public static void main(String[] args) {
		int[] nums = new int[]{2, 0, 1};
		sortColors(nums);
		Arrays.stream(nums).forEach(System.out::print);
	}
	
	public static void sortColors(int[] nums) {
		int i = 0, l = 0, r = nums.length - 1;
		while (i <= r) {
			int num = nums[i];
			if (num == 0) {
				swap(nums, l, i);
				l++;
				i++;
			} else if (num == 2) {
				swap(nums, r, i);
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
