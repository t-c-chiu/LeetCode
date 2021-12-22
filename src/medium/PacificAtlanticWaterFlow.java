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
		boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			dfs(heights, pacific, i, 0, 0);
			dfs(heights, atlantic, i, n - 1, 0);
		}
		for (int j = 0; j < n; j++) {
			dfs(heights, pacific, 0, j, 0);
			dfs(heights, atlantic, m - 1, j, 0);
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
	
	private static void dfs(int[][] heights, boolean[][] visited, int i, int j, int height) {
		if (i < 0 || i == heights.length || j < 0 || j == heights[i].length || visited[i][j] || heights[i][j] < height) {
			return;
		}
		visited[i][j] = true;
		dfs(heights, visited, i + 1, j, heights[i][j]);
		dfs(heights, visited, i - 1, j, heights[i][j]);
		dfs(heights, visited, i, j + 1, heights[i][j]);
		dfs(heights, visited, i, j - 1, heights[i][j]);
	}
	
}
