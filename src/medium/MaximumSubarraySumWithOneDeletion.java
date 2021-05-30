package medium;

public class MaximumSubarraySumWithOneDeletion {
	
	public static void main(String[] args) {
		int res = maximumSum(new int[]{1, -2, -2, 3});
		System.out.println(res);
	}
	
	public static int maximumSum(int[] arr) {
		int len = arr.length;
		int[] maxEndHere = new int[len];
		maxEndHere[0] = arr[0];
		int max = arr[0];
		for (int i = 1; i < len; i++) {
			maxEndHere[i] = Math.max(maxEndHere[i - 1] + arr[i], arr[i]);
			max = Math.max(max, maxEndHere[i]);
		}
		int[] maxStartHere = new int[len];
		maxStartHere[len - 1] = arr[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			maxStartHere[i] = Math.max(maxStartHere[i + 1] + arr[i], arr[i]);
		}
		for (int i = 1; i < len - 1; i++) {
			max = Math.max(max, maxEndHere[i - 1] + maxStartHere[i + 1]);
		}
		return max;
	}
}
