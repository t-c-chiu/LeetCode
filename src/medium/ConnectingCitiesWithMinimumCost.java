package medium;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectingCitiesWithMinimumCost {
	
	public static void main(String[] args) {
		int res = minimumCost(3, new int[][]{
				{1, 2, 5},
				{1, 3, 6},
				{2, 3, 1},
		});
		System.out.println(res);
	}
	
	public static int minimumCost(int n, int[][] connections) {
		int[] parent = new int[n + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		Arrays.sort(connections, Comparator.comparingInt(o -> o[2]));
		int res = 0;
		for (int[] connection : connections) {
			int c1 = connection[0];
			int c2 = connection[1];
			if (isConnected(c1, c2, parent)) {
				continue;
			}
			res += connection[2];
			connect(c1, c2, parent);
			n--;
		}
		return n == 1 ? res : -1;
	}
	
	private static void connect(int c1, int c2, int[] parent) {
		int p1 = findParent(c1, parent);
		int p2 = findParent(c2, parent);
		parent[p1] = p2;
	}
	
	private static boolean isConnected(int c1, int c2, int[] parent) {
		int p1 = findParent(c1, parent);
		int p2 = findParent(c2, parent);
		return p1 == p2;
	}
	
	private static int findParent(int c, int[] parent) {
		if (parent[c] == c) {
			return parent[c];
		}
		parent[c] = findParent(parent[c], parent);
		return parent[c];
	}
}
