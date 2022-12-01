package medium;

import java.util.*;

public class DetonateTheMaximumBombs {
	
	public static void main(String[] args) {
		int res = maximumDetonation(new int[][]{{1, 1, 100000}, {100000, 100000, 1}});
		System.out.println(res);
	}
	
	public static int maximumDetonation(int[][] bombs) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int n = bombs.length;
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int[] bomb1 = bombs[i], bomb2 = bombs[j];
				long disX = bomb1[0] - bomb2[0], disY = bomb1[1] - bomb2[1], dis = disX * disX + disY * disY;
				if (dis <= (long) bomb1[2] * bomb1[2]) {
					map.get(i).add(j);
				}
				if (dis <= (long) bomb2[2] * bomb2[2]) {
					map.get(j).add(i);
				}
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			Set<Integer> seen = new HashSet<>();
			seen.add(i);
			res = Math.max(res, dfs(map, i, seen));
		}
		return res;
	}
	
	private static int dfs(Map<Integer, List<Integer>> map, int i, Set<Integer> seen) {
		int res = 1;
		for (Integer next : map.get(i)) {
			if (!seen.contains(next)) {
				seen.add(next);
				res += dfs(map, next, seen);
			}
		}
		return res;
	}
}
