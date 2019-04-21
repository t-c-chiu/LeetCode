package easy;

public class Toeplitz_Matrix {
	
	public static void main(String[] args) {
		Toeplitz_Matrix test = new Toeplitz_Matrix();
		System.out.println(test.isToeplitzMatrix(new int[][]{
						{1, 2, 3, 4},
						{5, 1, 2, 3},
						{9, 5, 1, 2}
				}
		));
		
		System.out.println(test.isToeplitzMatrix(new int[][]{
						{1, 2},
						{2, 2}
				}
		));
	}
	
	public boolean isToeplitzMatrix(int[][] matrix) {
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i - 1][j - 1] != matrix[i][j])
					return false;
			}
		}
		return true;
	}
}
