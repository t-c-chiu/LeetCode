package medium;

public class NumberOfOperationsToMakeNetworkConnected {
	
	public static void main(String[] args) {
		int res = makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}});
		System.out.println(res);
	}
	
	public static int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1) {
			return -1;
		}
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for (int[] con : connections) {
			int p1 = find(parent, con[0]);
			int p2 = find(parent, con[1]);
			if (p1 != p2) {
				n--;
				parent[p1] = p2;
			}
		}
		return n - 1;
	}
	
	private static int find(int[] parent, int i) {
		if (parent[i] != i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}
//	public static int makeConnected(int n, int[][] connections) {
//		if (connections.length < n - 1) {
//			return -1;
//		}
//		Map<Integer, List<Integer>> g = new HashMap<>();
//		for (int i = 0; i < n; i++) {
//			g.put(i, new ArrayList<>());
//		}
//		for (int[] c : connections) {
//			g.get(c[0]).add(c[1]);
//			g.get(c[1]).add(c[0]);
//		}
//		boolean[] visited = new boolean[n];
//		int circle = 0;
//		for (int i = 0; i < n; i++) {
//			if (!visited[i]) {
//				visited[i] = true;
//				circle++;
//				dfs(g, i, visited);
//			}
//		}
//		return circle - 1;
//	}
//
//	private static void dfs(Map<Integer, List<Integer>> g, int i, boolean[] visited) {
//		for (Integer next : g.get(i)) {
//			if (!visited[next]) {
//				visited[next] = true;
//				dfs(g, next, visited);
//			}
//		}
//	}
	
}
