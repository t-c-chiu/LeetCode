package medium;

import java.util.Arrays;

public class TheKStrongestValuesInAnArray {
	
	public static void main(String[] args) {
		int[] res = getStrongest(new int[]{1, 1, 3, 5, 5}, 2);
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] getStrongest(int[] arr, int k) {
		Arrays.sort(arr);
		int n = arr.length, median = arr[(n - 1) / 2], l = 0, r = n - 1, i = 0;
		int[] res = new int[k];
		while (l <= r && i < k) {
			int lDiff = Math.abs(arr[l] - median);
			int rDiff = Math.abs(arr[r] - median);
			if (lDiff <= rDiff) {
				res[i] = arr[r--];
			} else {
				res[i] = arr[l++];
			}
			i++;
		}
		return res;
	}
}
