package medium;

public class MaximalSquare {
	
	public static void main(String[] args) {
		int res = maximalSquare(new char[][]{
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '1', '1', '1'}
		});
		System.out.println(res);
	}
	
	public static int maximalSquare(char[][] matrix) {
		int m = matrix.length, n = matrix[0].length, side = 0;
		int[][] max = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					max[i][j] = matrix[i][j] - '0';
				} else {
					max[i][j] = matrix[i][j] == '1' ? Math.min(max[i - 1][j - 1], Math.min(max[i - 1][j], max[i][j - 1])) + 1 : 0;
				}
				side = Math.max(side, max[i][j]);
			}
		}
		return side * side;
	}
}
