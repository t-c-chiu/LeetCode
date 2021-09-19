package medium;

import java.util.*;

public class MinimumAreaRectangle {
	
	public static void main(String[] args) {
		int res = minAreaRect(new int[][]{
				{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3},
		});
		System.out.println(res);
	}
	
	public static int minAreaRect(int[][] points) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] point : points) {
			map.putIfAbsent(point[0], new HashSet<>());
			map.get(point[0]).add(point[1]);
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int[] p1 = points[i], p2 = points[j];
				if (p1[0] == p2[0] || p1[1] == p2[1]) {
					continue;
				}
				if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
					res = Math.min(res, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
				}
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
