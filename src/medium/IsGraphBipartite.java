package medium;

public class IsGraphBipartite {
	
	public static void main(String[] args) {
		boolean res = isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
		System.out.println(res);
	}
	
	public static boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] group = new int[n];
		for (int i = 0; i < n; i++) {
			if (!dfs(graph, group, i, 1)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean dfs(int[][] graph, int[] group, int i, int g) {
		if (group[i] != 0) {
			return true;
		}
		group[i] = g;
		for (int next : graph[i]) {
			if (group[next] == g) {
				return false;
			}
			if (!dfs(graph, group, next, g * -1)) {
				return false;
			}
		}
		return true;
	}
	
}
