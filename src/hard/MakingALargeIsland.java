package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
	
	public static void main(String[] args) {
		int res = largestIsland(new int[][]{
				{1, 0, 1},
				{0, 0, 1},
				{0, 1, 1},
		});
		System.out.println(res);
	}
	
	static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static int largestIsland(int[][] grid) {
		int m = grid.length, n = grid.length, index = 2, res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					int area = dfs(grid, i, j, m, n, index);
					map.put(index, area);
					index++;
					res = Math.max(res, area);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					Set<Integer> seen = new HashSet<>();
					int area = 1;
					for (int[] dir : dirs) {
						int r = i + dir[0], c = j + dir[1];
						if (r < 0 || r == m || c < 0 || c == n || grid[r][c] == 0 || seen.contains(grid[r][c])) {
							continue;
						}
						seen.add(grid[r][c]);
						area += map.get(grid[r][c]);
					}
					res = Math.max(res, area);
				}
			}
		}
		return res;
	}
	
	private static int dfs(int[][] grid, int i, int j, int m, int n, int index) {
		if (i < 0 || i == m || j < 0 || j == n || grid[i][j] != 1) {
			return 0;
		}
		grid[i][j] = index;
		int area = 1;
		for (int[] dir : dirs) {
			area += dfs(grid, i + dir[0], j + dir[1], m, n, index);
		}
		return area;
	}
}
