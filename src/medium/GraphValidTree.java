package medium;

public class GraphValidTree {
	
	public static void main(String[] args) {
		boolean res = validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}});
		System.out.println(res);
	}
	
	public static boolean validTree(int n, int[][] edges) {
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for (int[] edge : edges) {
			int p1 = find(parent, edge[0]);
			int p2 = find(parent, edge[1]);
			if (p1 == p2) {
				return false;
			}
			parent[p1] = p2;
			n--;
		}
		return n == 1;
	}
	
	private static int find(int[] parent, int i) {
		if (parent[i] != i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}
//	public static boolean validTree(int n, int[][] edges) {
//		Map<Integer, List<Integer>> graph = new HashMap<>();
//		for (int i = 0; i < n; i++) {
//			graph.put(i, new ArrayList<>());
//		}
//		for (int[] edge : edges) {
//			graph.get(edge[0]).add(edge[1]);
//			graph.get(edge[1]).add(edge[0]);
//		}
//		Set<Integer> seen = new HashSet<>();
//		return dfs(0, -1, graph, seen) && seen.size() == n;
//	}
//
//	private static boolean dfs(int cur, int p, Map<Integer, List<Integer>> graph, Set<Integer> seen) {
//		seen.add(cur);
//		for (Integer next : graph.get(cur)) {
//			if (next == p) {
//				continue;
//			}
//			if (seen.contains(next) || !dfs(next, cur, graph, seen)) {
//				return false;
//			}
//		}
//		return true;
//	}
	
}
