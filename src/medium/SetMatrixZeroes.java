package medium;

import java.util.Arrays;

public class SetMatrixZeroes {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{0, 1, 2, 0},
				{3, 4, 5, 2},
				{1, 3, 1, 5}
		};
		setZeroes(matrix);
		Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
	}
	
	public static void setZeroes(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		boolean firstRowZero = false, firstColZero = false;
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0) {
				firstRowZero = true;
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (firstRowZero) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
		if (firstColZero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
