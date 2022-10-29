package medium;

import java.util.*;

public class ReachableNodesWithRestrictions {
	
	public static void main(String[] args) {
		int res = reachableNodes(7, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}}, new int[]{4, 5});
		System.out.println(res);
	}
	
	public static int reachableNodes(int n, int[][] edges, int[] restricted) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		Set<Integer> seen = new HashSet<>();
		for (int i : restricted) {
			seen.add(i);
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		seen.add(0);
		int res = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			res++;
			for (Integer next : graph.get(cur)) {
				if (seen.contains(next)) {
					continue;
				}
				seen.add(next);
				queue.offer(next);
			}
		}
		return res;
	}
}
