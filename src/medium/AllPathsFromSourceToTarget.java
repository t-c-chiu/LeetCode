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
		backtrack(res, graph, 0, path);
		return res;
	}
	
	private static void backtrack(List<List<Integer>> res, int[][] graph, int from, List<Integer> temp) {
		if (from == graph.length - 1) {
			res.add(new ArrayList<>(temp));
		} else {
			for (int next : graph[from]) {
				temp.add(next);
				backtrack(res, graph, next, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
