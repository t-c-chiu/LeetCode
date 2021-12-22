package medium;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {
	
	public static void main(String[] args) {
		int res = makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}});
		System.out.println(res);
	}
	
	public static int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1) {
			return -1;
		}
		
		List<Integer>[] graph = new List[n];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] c : connections) {
			graph[c[0]].add(c[1]);
			graph[c[1]].add(c[0]);
		}
		int res = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			res += dfs(graph, visited, i);
		}
		return res - 1;
	}
	
	private static int dfs(List<Integer>[] graph, boolean[] visited, int i) {
		if (visited[i]) {
			return 0;
		}
		visited[i] = true;
		for (Integer next : graph[i]) {
			dfs(graph, visited, next);
		}
		return 1;
	}

//	public static int makeConnected(int n, int[][] connections) {
//		if (connections.length < n - 1) {
//			return -1;
//		}
//
//		int[] parent = new int[n];
//		for (int i = 0; i < parent.length; i++) {
//			parent[i] = i;
//		}
//		int res = n - 1;
//		for (int[] c : connections) {
//			int p1 = findParent(parent, c[0]);
//			int p2 = findParent(parent, c[1]);
//			if (p1 != p2) {
//				merge(parent, p1, p2);
//				res--;
//			}
//		}
//		return res;
//	}
//
//	private static void merge(int[] parent, int p1, int p2) {
//		if (p1 < p2) {
//			parent[p2] = p1;
//		} else {
//			parent[p1] = p2;
//		}
//	}
//
//	private static int findParent(int[] parent, int i) {
//		if (parent[i] != i) {
//			return parent[i] = findParent(parent, parent[i]);
//		}
//		return i;
//	}
}
