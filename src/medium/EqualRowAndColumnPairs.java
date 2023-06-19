package medium;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
	
	public static void main(String[] args) {
		int res = equalPairs(new int[][]{
				{3, 2, 1},
				{1, 7, 6},
				{2, 7, 7}});
		System.out.println(res);
	}
	
	public static int equalPairs(int[][] grid) {
		int res = 0, n = grid.length;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < n; j++) {
				builder.append(grid[i][j]).append(",");
			}
			String key = builder.toString();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		for (int i = 0; i < n; i++) {
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < n; j++) {
				builder.append(grid[j][i]).append(",");
			}
			String key = builder.toString();
			res += map.getOrDefault(key, 0);
		}
		return res;
	}
	
}
