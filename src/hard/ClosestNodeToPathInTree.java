package hard;

import java.util.*;

public class ClosestNodeToPathInTree {
	
	public static void main(String[] args) {
		int[] res = closestNode(7, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}, {2, 5}, {2, 6}}, new int[][]{{5, 3, 4}, {5, 3, 6}});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] closestNode(int n, int[][] edges, int[][] query) {
		int m = query.length;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.putIfAbsent(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			int u = edge[0], v = edge[1];
			map.get(u).add(v);
			map.get(v).add(u);
		}
		int[] res = new int[m];
		Map<Integer, Map<Integer, Set<Integer>>> pathCache = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int from = query[i][0], to = query[i][1];
			Set<Integer> path;
			if (pathCache.containsKey(from) && pathCache.get(from).containsKey(to)) {
				path = pathCache.get(from).get(to);
			} else {
				path = new HashSet<>();
				dfs(map, from, to, path);
				pathCache.putIfAbsent(from, new HashMap<>());
				pathCache.get(from).put(to, path);
			}
			res[i] = bfs(map, query[i][2], path);
		}
		return res;
	}
	
	private static int bfs(Map<Integer, List<Integer>> map, Integer node, Set<Integer> path) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		Set<Integer> seen = new HashSet<>();
		seen.add(node);
		while (!queue.isEmpty()) {
			Integer cur = queue.poll();
			if (path.contains(cur)) {
				return cur;
			}
			for (Integer next : map.get(cur)) {
				if (seen.contains(next)) {
					continue;
				}
				seen.add(next);
				queue.offer(next);
			}
		}
		return -1;
	}
	
	private static boolean dfs(Map<Integer, List<Integer>> map, int from, int to, Set<Integer> path) {
		path.add(from);
		if (from == to) {
			return true;
		}
		for (Integer next : map.get(from)) {
			if (path.contains(next)) {
				continue;
			}
			if (dfs(map, next, to, path)) {
				return true;
			}
		}
		path.remove(from);
		return false;
	}
}
