package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
	
	public static void main(String[] args) {
		List<List<Integer>> res = pacificAtlantic(new int[][]{
				{1, 2, 3},
				{8, 9, 4},
				{7, 6, 5},
		});
		System.out.println(res);
	}
	
	public static List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> res = new ArrayList<>();
		int m = heights.length, n = heights[0].length;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			dfs(pacific, heights, i, 0, m, n, 0);
			dfs(atlantic, heights, i, n - 1, m, n, 0);
		}
		for (int j = 0; j < n; j++) {
			dfs(pacific, heights, 0, j, m, n, 0);
			dfs(atlantic, heights, m - 1, j, m, n, 0);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					res.add(Arrays.asList(i, j));
				}
			}
		}
		return res;
	}
	
	private static void dfs(boolean[][] ocean, int[][] heights, int i, int j, int m, int n, int pre) {
		if (i < 0 || i == m || j < 0 || j == n || ocean[i][j] || heights[i][j] < pre) {
			return;
		}
		ocean[i][j] = true;
		dfs(ocean, heights, i - 1, j, m, n, heights[i][j]);
		dfs(ocean, heights, i + 1, j, m, n, heights[i][j]);
		dfs(ocean, heights, i, j - 1, m, n, heights[i][j]);
		dfs(ocean, heights, i, j + 1, m, n, heights[i][j]);
	}
	
}
