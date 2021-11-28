package medium;

import java.util.*;

public class AllPathsFromSourceToTarget {
	
	public static void main(String[] args) {
		allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}})
				.forEach(System.out::println);
	}
	
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		dfs(graph, 0, path, res);
		return res;
	}
	
	private static void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
		if (node == graph.length - 1) {
			res.add(new ArrayList<>(path));
			return;
		}
		
		for (int next : graph[node]) {
			path.add(next);
			dfs(graph, next, path, res);
			path.remove(path.size() - 1);
		}
	}
}
