package medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
	
	public static void main(String[] args) {
		int res = numDistinctIslands(new int[][]{
				{1, 1, 0, 1, 1},
				{1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1},
				{1, 1, 0, 1, 1}
		});
		System.out.println(res);
	}
	
	public static int numDistinctIslands(int[][] grid) {
		Set<String> set = new HashSet<>();
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					StringBuilder builder = new StringBuilder();
					dfs(grid, i, j, 0, 0, builder);
					set.add(builder.toString());
				}
			}
		}
		return set.size();
	}
	
	private static void dfs(int[][] grid, int i, int j, int x, int y, StringBuilder builder) {
		int m = grid.length, n = grid[0].length;
		if (i < 0 || i == m || j < 0 || j == n || grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		builder.append(x).append(",").append(y).append("|");
		dfs(grid, i + 1, j, x + 1, y, builder);
		dfs(grid, i - 1, j, x - 1, y, builder);
		dfs(grid, i, j + 1, x, y + 1, builder);
		dfs(grid, i, j - 1, x, y - 1, builder);
	}
}
