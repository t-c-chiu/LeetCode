package medium;

import java.util.Arrays;

public class RotateImage {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		rotate(matrix);
		Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
		System.out.println();
		
		matrix = new int[][]{
				{5, 1, 9, 11},
				{2, 4, 8, 10},
				{13, 3, 6, 7},
				{15, 14, 12, 16}
		};
		rotate(matrix);
		Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
	}
	
	/***
	 * 1 2 3    1 4 7    7 4 1
	 * 4 5 6 -> 2 5 8 -> 8 5 2
	 * 7 8 9    3 6 9    9 6 3
	 */
	public static void rotate(int[][] matrix) {
		int m = matrix.length;
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < m; i++) {
			reverse(matrix[i]);
		}
	}
	
	private static void reverse(int[] row) {
		int left = 0, right = row.length - 1;
		while (left < right) {
			int temp = row[left];
			row[left] = row[right];
			row[right] = temp;
			left++;
			right--;
		}
	}
}
