package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
	
	public static void main(String[] args) {
		int res = countComponents(5, new int[][]{
				{0, 1},
				{1, 2},
//				{2, 3},
				{3, 4},
		});
		System.out.println(res);
	}
	
	public static int countComponents(int n, int[][] edges) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new HashSet<>());
		}
		for (int[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}
		boolean[] visited = new boolean[n];
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(map, visited, i);
				res++;
			}
		}
		return res;
	}
	
	private static void dfs(Map<Integer, Set<Integer>> map, boolean[] visited, int i) {
		Set<Integer> set = map.get(i);
		for (Integer next : set) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(map, visited, next);
			}
		}
	}

//	public static int countComponents(int n, int[][] edges) {
//		int[] parent = new int[n];
//		for (int i = 0; i < n; i++) {
//			parent[i] = i;
//		}
//
//		for (int[] edge : edges) {
//			int p1 = findParent(parent, edge[0]);
//			int p2 = findParent(parent, edge[1]);
//			if (p1 == p2) {
//				continue;
//			}
//			parent[p1] = p2;
//			n--;
//		}
//		return n;
//	}
//
//	private static int findParent(int[] parent, int i) {
//		if (parent[i] == i) {
//			return i;
//		}
//		parent[i] = findParent(parent, parent[i]);
//		return parent[i];
//	}
}
