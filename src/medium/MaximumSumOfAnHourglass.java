package medium;

public class MaximumSumOfAnHourglass {
	
	public static void main(String[] args) {
	
	}
	
	public static int maxSum(int[][] grid) {
		int m = grid.length, n = grid[0].length, res = 0;
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				int sum = grid[i][j];
				for (int k = -1; k <= 1; k++) {
					sum += grid[i - 1][j + k] + grid[i + 1][j + k];
				}
				res = Math.max(res, sum);
			}
		}
		return res;
	}
}
