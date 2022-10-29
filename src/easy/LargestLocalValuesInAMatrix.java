package easy;

import java.util.Arrays;

public class LargestLocalValuesInAMatrix {
	
	public static void main(String[] args) {
		int[][] res = largestLocal(new int[][]{
				{9, 9, 8, 1},
				{5, 6, 2, 6},
				{8, 2, 6, 4},
				{6, 2, 2, 2}}
		);
		for (int[] row : res) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static int[][] largestLocal(int[][] grid) {
		int n = grid.length;
		int[][] res = new int[n - 2][n - 2];
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < n - 2; j++) {
				int max = Integer.MIN_VALUE;
				for (int a = 0; a < 3; a++) {
					for (int b = 0; b < 3; b++) {
						max = Math.max(max, grid[i + a][j + b]);
					}
				}
				res[i][j] = max;
			}
		}
		return res;
	}
}
