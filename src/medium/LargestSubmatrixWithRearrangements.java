package medium;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {
	
	public static void main(String[] args) {
		int res = largestSubmatrix(new int[][]{
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
				{0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
		});
		System.out.println(res);
	}
	
	/**
	 * 0 0 1 0
	 * 1 1 2 1
	 * 2 0 3 2
	 * 0 1 0 3
	 */
	public static int largestSubmatrix(int[][] matrix) {
		int res = 0, m = matrix.length, n = matrix[0].length;
		for (int j = 0; j < n; j++) {
			int count = 0;
			for (int i = 0; i < m; i++) {
				if (matrix[i][j] == 1) {
					count++;
				} else {
					count = 0;
				}
				matrix[i][j] = count;
			}
		}
		
		for (int i = 0; i < m; i++) {
			Arrays.sort(matrix[i]);
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] != 0) {
					res = Math.max(res, matrix[i][j] * (n - j));
				}
			}
		}
		return res;
	}
}
