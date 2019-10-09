package medium;

import java.util.*;

public class AllPathsFromSourceToTarget {
	
	public static void main(String[] args) {
		AllPathsFromSourceToTarget test = new AllPathsFromSourceToTarget();
//		test.allPathsSourceTarget(new int[][]{{1}, {2}, {}}).forEach(System.out::println);
		test.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {4}, {4}, {5, 6}, {7}, {7}, {}}).forEach(System.out::println);
	}
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		backtrack(graph, 0, res, path);
		return res;
	}
	
	private void backtrack(int[][] graph, int index, List<List<Integer>> res, List<Integer> path) {
		if (index == graph.length - 1) {
			res.add(new ArrayList<>(path));
			return;
		}
		
		for (int nextIndex : graph[index]) {
			path.add(nextIndex);
			backtrack(graph, nextIndex, res, path);
			path.remove(path.size() - 1);
		}
	}
}
