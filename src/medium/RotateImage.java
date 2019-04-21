package medium;

public class RotateImage {
	
	public static void main(String[] args) {
		RotateImage test = new RotateImage();
		int[][] matrix = new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		test.rotate(matrix);
		test.printMatrix(matrix);
		
		matrix = new int[][]{
				{5, 1, 9, 11},
				{2, 4, 8, 10},
				{13, 3, 6, 7},
				{15, 14, 12, 16}
		};
		test.rotate(matrix);
		test.printMatrix(matrix);
	}
	
	
	//  [1,2,3]    [7,2,1]    [7,4,1]
	//  [4,5,6] -> [4,5,6] -> [8,5,2]
	//  [7,8,9]    [9,8,3]    [9,6,3]
	
	// {5, 1, 9, 11},
	// {2, 4, 8, 10},
	// {13, 3, 6, 7},
	// {15, 14, 12, 16}
	
	// 一次轉4格
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = tmp;
			}
		}
	}
	
	private void printMatrix(int[][] matrix) {
		for (int[] ints : matrix) {
			for (int i : ints) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}
}
