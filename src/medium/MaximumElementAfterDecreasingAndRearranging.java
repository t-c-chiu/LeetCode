package medium;

import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging {
	
	public static void main(String[] args) {
		int res = maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000});
		System.out.println(res);
	}
	
	public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		Arrays.sort(arr);
		int pre = 0;
		for (int i : arr) {
			pre = Math.min(pre + 1, i);
		}
		return pre;
	}
//	public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
//		Arrays.sort(arr);
//		int n = arr.length;
//		arr[0] = 1;
//		for (int i = 1; i < n; i++) {
//			if (arr[i] - arr[i - 1] > 1) {
//				arr[i] = arr[i - 1] + 1;
//			}
//		}
//		return arr[n - 1];
//	}
}
