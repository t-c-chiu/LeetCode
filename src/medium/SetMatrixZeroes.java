package medium;

public class SetMatrixZeroes {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{0, 1, 2, 0},
				{3, 4, 5, 2},
				{1, 3, 1, 5}
		};
		setZeroes(matrix);
		for (int[] array : matrix) {
			for (int i : array) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public static void setZeroes(int[][] matrix) {
		boolean firstRowZero = false;
		boolean firstColZero = false;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0)
				firstColZero = true;
		}
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0)
				firstRowZero = true;
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
