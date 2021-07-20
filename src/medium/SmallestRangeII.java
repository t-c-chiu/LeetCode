package medium;

import java.util.Arrays;

public class SmallestRangeII {
	
	public static void main(String[] args) {
		int res = smallestRangeII(new int[]{7, 8, 8}, 5);
		System.out.println(res);
	}
	
	public static int smallestRangeII(int[] A, int K) {
		int n = A.length;
		Arrays.sort(A);
		int min = A[0];
		int max = A[n - 1];
		int res = max - min;
		for (int i = 0; i < n - 1; i++) {
			max = Math.max(A[i] + K, A[n - 1] - K);
			min = Math.min(A[0] + K, A[i + 1] - K);
			res = Math.min(res, max - min);
		}
		return res;
	}
}
