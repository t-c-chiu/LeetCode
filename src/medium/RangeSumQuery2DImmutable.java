package medium;

public class RangeSumQuery2DImmutable {
	
	public static void main(String[] args) {
		NumMatrix numMatrix = new NumMatrix(new int[][]{
				{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7}, {
				1, 0, 3, 0, 5}});
		numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
		numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
		numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
	}
	
	static class NumMatrix {
		
		int[][] sum;
		
		public NumMatrix(int[][] matrix) {
			int m = matrix.length;
			int n = matrix[0].length;
			sum = new int[m + 1][n + 1];
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
				}
			}
		}
		
		public int sumRegion(int row1, int col1, int row2, int col2) {
			return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
		}
	}
}
