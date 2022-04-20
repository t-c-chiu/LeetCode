package medium;

public class RemoveAllOnesWithRowAndColumnFlips {
	
	public static void main(String[] args) {
		boolean res = removeOnes(new int[][]{
				{0, 1, 0},
				{1, 0, 1},
				{0, 1, 0}});
		System.out.println(res);
	}
	
	public static boolean removeOnes(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int j = 0; j < n; j++) {
			if (grid[0][j] == 1) {
				flip(grid, j);
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (grid[i][j] != grid[i][j - 1]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void flip(int[][] grid, int c) {
		for (int i = 0; i < grid.length; i++) {
			grid[i][c] = grid[i][c] == 0 ? 1 : 0;
		}
	}
}
