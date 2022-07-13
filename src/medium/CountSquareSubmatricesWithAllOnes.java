package medium;

public class CountSquareSubmatricesWithAllOnes {
	
	public static void main(String[] args) {
		int res = countSquares(new int[][]{
				{0, 1, 1, 1},
				{1, 1, 1, 1},
				{0, 1, 1, 1}});
		System.out.println(res);
	}
	
	public static int countSquares(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length, res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0 && j > 0 && matrix[i][j] == 1) {
					matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
				}
				res += matrix[i][j];
			}
		}
		return res;
	}
}
