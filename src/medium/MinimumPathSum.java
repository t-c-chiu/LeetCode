package medium;

public class MinimumPathSum {
	
	public static void main(String[] args) {
		MinimumPathSum test = new MinimumPathSum();
		final int res = test.minPathSum(new int[][]{
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		});
		System.out.println(res);
	}
	
	
	//	  1 3 1    1 4 5
	//	  1 5 1 -> 2 7 6
	//	  4 2 1    6 8 7
	public int minPathSum(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;
		
		int m = grid.length, n = grid[0].length;
		for (int i = 1; i < m; i++)
			grid[i][0] += grid[i - 1][0];
		
		for (int i = 1; i < n; i++)
			grid[0][i] += grid[0][i - 1];
		
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
		
		return grid[m - 1][n - 1];
	}
}
