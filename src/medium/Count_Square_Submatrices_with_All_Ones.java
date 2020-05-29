package medium;

public class Count_Square_Submatrices_with_All_Ones {
	
	public static void main(String[] args) {
		Count_Square_Submatrices_with_All_Ones test = new Count_Square_Submatrices_with_All_Ones();
		int res = test.countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}});
		System.out.println(res);
	}
	
	/**
	 * 0 1 1 1   0 1 1 1
	 * 1 1 1 1   1 1 2 2
	 * 0 1 1 1   0 1 2 3
	 */
	public int countSquares(int[][] matrix) {
		int res = 0, m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1 && i > 0 && j > 0) {
					matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
				}
				res += matrix[i][j];
			}
		}
		return res;
	}
}
