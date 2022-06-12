package medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
	
	public static void main(String[] args) {
		int res = numberOfBoomerangs(new int[][]{{1, 1}, {2, 2}, {3, 3}});
		System.out.println(res);
	}
	
	public static int numberOfBoomerangs(int[][] points) {
		int n = points.length, res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				int distance = getDistance(points[i], points[j]);
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}
			for (Integer count : map.values()) {
				res += count * (count - 1);
			}
			map.clear();
		}
		return res;
	}
	
	private static int getDistance(int[] p1, int[] p2) {
		int d1 = p1[0] - p2[0];
		int d2 = p1[1] - p2[1];
		return d1 * d1 + d2 * d2;
	}
}
