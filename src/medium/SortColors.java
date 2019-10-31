package medium;

import java.util.Arrays;

public class SortColors {
	
	public static void main(String[] args) {
		SortColors test = new SortColors();
		int[] nums = {0, 2, 1, 2, 2, 0, 0, 2};
		test.sortColors(nums);
		Arrays.stream(nums).forEach(System.out::print);
	}
	
	public void sortColors(int[] nums) {
		int len = nums.length;
		if (len < 2)
			return;
		
		int i = 0, low = 0, high = len - 1;
		while (i <= high) {
			if (nums[i] == 0) {
				swap(nums, i, low);
				i++;
				low++;
			} else if (nums[i] == 2) {
				swap(nums, i, high);
				high--;
			} else {
				i++;
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
