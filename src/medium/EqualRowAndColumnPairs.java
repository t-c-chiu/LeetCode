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
			StringBuilder sb = new StringBuilder();
			for (int num : grid[i]) {
				sb.append(num).append(',');
			}
			String s = sb.toString();
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		for (int j = 0; j < n; j++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append(grid[i][j]).append(',');
			}
			res += map.getOrDefault(sb.toString(), 0);
		}
		return res;
	}
	
	
}
