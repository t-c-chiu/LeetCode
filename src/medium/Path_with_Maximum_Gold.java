package medium;

public class Path_with_Maximum_Gold {
	
	public static void main(String[] args) {
		Path_with_Maximum_Gold test = new Path_with_Maximum_Gold();
		int res = test.getMaximumGold(new int[][]{
				{0, 6, 0},
				{5, 8, 7},
				{0, 9, 0}
		});
		System.out.println(res);
	}
	
	private int max;
	
	public int getMaximumGold(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				dig(grid, i, j, 0);
			}
		}
		return max;
	}
	
	private void dig(int[][] grid, int i, int j, int sum) {
		if (i < 0 || j < 0 || i == grid.length || j == grid[i].length || grid[i][j] == 0) {
			max = Math.max(max, sum);
			return;
		}
		int gold = grid[i][j];
		sum += gold;
		grid[i][j] = 0;
		dig(grid, i - 1, j, sum);
		dig(grid, i + 1, j, sum);
		dig(grid, i, j - 1, sum);
		dig(grid, i, j + 1, sum);
		grid[i][j] = gold;
	}
}
