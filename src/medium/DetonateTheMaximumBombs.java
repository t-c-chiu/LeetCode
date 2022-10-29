package medium;

import java.util.*;

public class DetonateTheMaximumBombs {
	
	public static void main(String[] args) {
		int res = maximumDetonation(new int[][]{{1, 1, 100000}, {100000, 100000, 1}});
		System.out.println(res);
	}
	
	public static int maximumDetonation(int[][] bombs) {
		int res = 0, n = bombs.length;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int[] bomb1 = bombs[i], bomb2 = bombs[j];
				long distanceX = bomb1[0] - bomb2[0], distanceY = bomb1[1] - bomb2[1],
						distance = distanceX * distanceX + distanceY * distanceY;
				if (distance <= (long) bomb1[2] * bomb1[2]) {
					graph.get(i).add(j);
				}
				if (distance <= (long) bomb2[2] * bomb2[2]) {
					graph.get(j).add(i);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			Set<Integer> seen = new HashSet<>();
			seen.add(i);
			res = Math.max(res, dfs(i, graph, seen));
		}
		return res;
	}
	
	private static int dfs(int bomb, Map<Integer, List<Integer>> graph, Set<Integer> seen) {
		int detonated = 1;
		for (Integer next : graph.get(bomb)) {
			if (!seen.contains(next)) {
				seen.add(next);
				detonated += dfs(next, graph, seen);
			}
		}
		return detonated;
	}
}
