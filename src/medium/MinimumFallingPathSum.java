package medium;

import java.util.Arrays;

public class MinimumFallingPathSum {
	
	public static void main(String[] args) {
		int res = minFallingPathSum(new int[][]{
				{2, 1, 3},
				{6, 5, 4},
				{7, 8, 9}});
		System.out.println(res);
	}
	
	/**
	 * 2  1  3
	 * 7  6  5
	 * 13 13 14
	 */
	public static int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int min = Integer.MAX_VALUE;
				if (j > 0) {
					min = Math.min(min, matrix[i - 1][j - 1]);
				}
				min = Math.min(min, matrix[i - 1][j]);
				if (j < n - 1) {
					min = Math.min(min, matrix[i - 1][j + 1]);
				}
				matrix[i][j] += min;
			}
		}
		return Arrays.stream(matrix[n - 1]).min().getAsInt();
	}
}
