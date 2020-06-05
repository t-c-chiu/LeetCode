package medium;

public class Matrix_Block_Sum {
	
	public static void main(String[] args) {
		Matrix_Block_Sum test = new Matrix_Block_Sum();
		int[][] res = test.matrixBlockSum(new int[][]{
						{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}},
				1);
		for (int[] arr : res) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * sum:
	 * 1  3  6
	 * 5  12 21
	 * 12 27 45
	 */
	public int[][] matrixBlockSum(int[][] mat, int K) {
		int m = mat.length, n = mat[0].length;
		int[][] sum = new int[m][n], res = new int[m][n];
		for (int i = 0; i < m; i++) {
			int rowSum = 0;
			for (int j = 0; j < n; j++) {
				rowSum += mat[i][j];
				sum[i][j] = rowSum;
				if (i > 0) {
					sum[i][j] += sum[i - 1][j];
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int r1 = Math.max(0, i - K);
				int c1 = Math.max(0, j - K);
				int r2 = Math.min(m - 1, i + K);
				int c2 = Math.min(n - 1, j + K);
				res[i][j] = sum[r2][c2];
				if (r1 > 0) {
					res[i][j] -= sum[r1 - 1][c2];
				}
				if (c1 > 0) {
					res[i][j] -= sum[r2][c1 - 1];
				}
				if (r1 > 0 && c1 > 0) {
					res[i][j] += sum[r1 - 1][c1 - 1];
				}
			}
		}
		
		return res;
	}
}
