package medium;

import java.util.Arrays;

public class SortColors {
	
	public static void main(String[] args) {
		int[] nums = new int[]{2, 0, 1};
		sortColors(nums);
		Arrays.stream(nums).forEach(System.out::print);
	}
	
	public static void sortColors(int[] nums) {
		int zero = 0, two = nums.length - 1, one = 0;
		while (one <= two) {
			if (nums[one] == 0) {
				swap(nums, zero++, one++);
			} else if (nums[one] == 2) {
				swap(nums, one, two--);
			} else {
				one++;
			}
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
}
