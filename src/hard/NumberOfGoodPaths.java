package hard;

import java.util.*;

public class NumberOfGoodPaths {
	
	public static void main(String[] args) {
		int res = numberOfGoodPaths(new int[]{1, 3, 2, 1, 3}, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}});
		System.out.println(res);
	}
	
	public static int numberOfGoodPaths(int[] vals, int[][] edges) {
		int n = vals.length, res = 0;
		TreeMap<Integer, List<Integer>> sameValue = new TreeMap<>();
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sameValue.putIfAbsent(vals[i], new ArrayList<>());
			sameValue.get(vals[i]).add(i);
			graph.put(i, new HashSet<>());
		}
		for (int[] edge : edges) {
			int u = edge[0], v = edge[1];
			if (vals[u] >= vals[v]) {
				graph.get(u).add(v);
			}
			if (vals[v] >= vals[u]) {
				graph.get(v).add(u);
			}
		}
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for (Integer val : sameValue.keySet()) {
			List<Integer> nodes = sameValue.get(val);
			for (Integer u : nodes) {
				for (Integer v : graph.get(u)) {
					int p1 = find(parent, u);
					int p2 = find(parent, v);
					if (p1 != p2) {
						parent[p1] = p2;
					}
				}
			}
			Map<Integer, Integer> group = new HashMap<>();
			for (Integer u : nodes) {
				int p = find(parent, u);
				group.put(p, group.getOrDefault(p, 0) + 1);
			}
			res += nodes.size();
			for (Integer p : group.keySet()) {
				int size = group.get(p);
				res += size * (size - 1) / 2;
			}
		}
		return res;
	}
	
	private static int find(int[] parent, Integer i) {
		if (parent[i] != i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}
}
