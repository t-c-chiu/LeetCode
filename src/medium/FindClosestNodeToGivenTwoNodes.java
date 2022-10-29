package medium;

import java.util.*;

public class FindClosestNodeToGivenTwoNodes {
	
	public static void main(String[] args) {
		int res = closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1);
		System.out.println(res);
	}
	
	public static int closestMeetingNode(int[] edges, int node1, int node2) {
		int n = edges.length;
		int[] maxFromNode1 = new int[n], maxFromNode2 = new int[n];
		Arrays.fill(maxFromNode1, Integer.MAX_VALUE);
		Arrays.fill(maxFromNode2, Integer.MAX_VALUE);
		dfs(maxFromNode1, node1, 0, edges, new HashSet<>());
		dfs(maxFromNode2, node2, 0, edges, new HashSet<>());
		int res = -1, max = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int temp = Math.max(maxFromNode1[i], maxFromNode2[i]);
			if (temp < max) {
				max = temp;
				res = i;
			}
		}
		return res;
	}
	
	private static void dfs(int[] max, int node, int step, int[] edges, Set<Integer> seen) {
		if (node == -1 || !seen.add(node)) {
			return;
		}
		max[node] = step;
		dfs(max, edges[node], step + 1, edges, seen);
	}
}
