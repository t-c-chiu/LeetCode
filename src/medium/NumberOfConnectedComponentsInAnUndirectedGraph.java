package medium;

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
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		for (int[] edge : edges) {
			int p1 = find(p, edge[0]);
			int p2 = find(p, edge[1]);
			if (p1 != p2) {
				p[p1] = p2;
				n--;
			}
		}
		return n;
	}
	
	private static int find(int[] p, int i) {
		if (p[i] != i) {
			p[i] = find(p, p[i]);
		}
		return p[i];
	}
//	public static int countComponents(int n, int[][] edges) {
//		Map<Integer, List<Integer>> g = new HashMap<>();
//		for (int i = 0; i < n; i++) {
//			g.put(i, new ArrayList<>());
//		}
//		for (int[] edge : edges) {
//			g.get(edge[0]).add(edge[1]);
//			g.get(edge[1]).add(edge[0]);
//		}
//		int res = 0;
//		Set<Integer> seen = new HashSet<>();
//		for (int i = 0; i < n; i++) {
//			if (!seen.contains(i)) {
//				dfs(i, g, seen);
//				res++;
//			}
//		}
//		return res;
//	}
//
//	private static void dfs(int i, Map<Integer, List<Integer>> g, Set<Integer> seen) {
//		seen.add(i);
//		for (Integer next : g.get(i)) {
//			if (!seen.contains(next)) {
//				dfs(next, g, seen);
//			}
//		}
//	}


}
