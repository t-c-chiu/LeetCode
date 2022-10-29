package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestCycleInAGraph {
	
	public static void main(String[] args) {
		int res = longestCycle(new int[]{3, 3, 4, 2, 3});
		System.out.println(res);
	}
	
	static int res = -1;
	
	public static int longestCycle(int[] edges) {
		int n = edges.length;
		Set<Integer> seen = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!seen.contains(i)) {
				dfs(i, edges, seen, new HashMap<>(), 0);
			}
		}
		return res;
	}
	
	private static void dfs(int node, int[] edges, Set<Integer> seen, Map<Integer, Integer> lastStep, int step) {
		if (lastStep.containsKey(node)) {
			res = Math.max(res, step - lastStep.get(node));
			return;
		}
		if (edges[node] == -1 || seen.contains(node)) {
			return;
		}
		seen.add(node);
		lastStep.put(node, step);
		dfs(edges[node], edges, seen, lastStep, step + 1);
	}
}
