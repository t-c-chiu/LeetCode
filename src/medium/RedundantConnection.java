package medium;

import java.util.Arrays;

public class RedundantConnection {
	
	public static void main(String[] args) {
		int[] res = findRedundantConnection(new int[][]{
				{1, 2},
				{2, 3},
				{3, 4},
				{1, 4},
				{1, 5},
		});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		int[] parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		for (int[] edge : edges) {
			int p1 = find(parent, edge[0]);
			int p2 = find(parent, edge[1]);
			if (p1 == p2) {
				return edge;
			}
			parent[p1] = p2;
		}
		return new int[2];
	}
	
	private static int find(int[] parent, int i) {
		if (parent[i] != i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}
}
