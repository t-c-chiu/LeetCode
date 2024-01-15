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
		int m = grid.length, n = grid[0].length, index = 2, res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					int area = dfs(grid, i, j, m, n, index);
					res = Math.max(res, area);
					map.put(index, area);
					index++;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Set<Integer> seen = new HashSet<>();
				if (grid[i][j] == 0) {
					int area = 1;
					for (int[] dir : dirs) {
						int nx = i + dir[0], ny = j + dir[1];
						if (nx < 0 || nx == m || ny < 0 || ny == n || grid[nx][ny] == 0 || seen.contains(grid[nx][ny])) {
							continue;
						}
						seen.add(grid[nx][ny]);
						area += map.get(grid[nx][ny]);
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
