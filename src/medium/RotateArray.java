package medium;

import java.util.Arrays;

public class RotateArray {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		rotate(arr, 3);
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
	}
	
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}
	
	private static void reverse(int[] nums, int l, int r) {
		while (l < r) {
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			l++;
			r--;
		}
	}
}
