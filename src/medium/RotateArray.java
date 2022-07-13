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
	
	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
//	public static void rotate(int[] nums, int k) {
//		int n = nums.length, i = 0;
//		k %= n;
//		int[] res = new int[n];
//		for (int j = n - k; j < n; j++) {
//			res[i++] = nums[j];
//		}
//		for (int j = 0; j < n - k; j++) {
//			res[i++] = nums[j];
//		}
//		for (int j = 0; j < n; j++) {
//			nums[j] = res[j];
//		}
//	}
}
