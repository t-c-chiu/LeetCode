package medium;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget {
	
	public static void main(String[] args) {
		int res = findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803);
		System.out.println(res);
	}
	
	public static int findBestValue(int[] arr, int target) {
		Arrays.sort(arr);
		int i = 0, n = arr.length;
		while (i < n && arr[i] * (n - i) < target) {
			target -= arr[i++];
		}
		if (i == n) {
			return arr[n - 1];
		}
		int res = target / (n - i);
		if (target - res * (n - i) > (res + 1) * (n - i) - target) {
			res++;
		}
		return res;
	}
}
