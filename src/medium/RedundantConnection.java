package medium;

public class RedundantConnection {
	
	public static void main(String[] args) {
		int[] res = findRedundantConnection(new int[][]{
				{1, 2},
				{2, 3},
				{3, 4},
				{1, 4},
				{1, 5},
		});
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] findRedundantConnection(int[][] edges) {
		int[] parents = new int[1001];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
		
		for (int[] edge : edges) {
			if (!union(parents, edge[0], edge[1])) {
				return edge;
			}
		}
		return new int[2];
	}
	
	private static boolean union(int[] parents, int i, int j) {
		int ip = find(parents, i);
		int jp = find(parents, j);
		if (ip == jp) {
			return false;
		}
		parents[ip] = jp;
		return true;
	}
	
	private static int find(int[] parents, int i) {
		if (parents[i] == i) {
			return i;
		}
		return find(parents, parents[i]);
	}
}
