package medium;

import java.util.*;

public class FindEventualSafeStates {
	
	public static void main(String[] args) {
		List<Integer> res = eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});
		System.out.println(res);
	}
	
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (dfs(graph, i, color)) {
				res.add(i);
			}
		}
		return res;
	}
	
	/**
	 * 0 : not visited
	 * 1 : visiting
	 * 2 : visited
	 */
	private static boolean dfs(int[][] graph, int i, int[] color) {
		if (color[i] > 0) {
			return color[i] == 2;
		}
		color[i] = 1;
		for (int next : graph[i]) {
			if (!dfs(graph, next, color)) {
				return false;
			}
		}
		color[i] = 2;
		return true;
	}

//	public static List<Integer> eventualSafeNodes(int[][] graph) {
//		int n = graph.length;
//		Map<Integer, List<Integer>> map = new HashMap<>();
//		int[] outDegree = new int[n];
//		for (int i = 0; i < n; i++) {
//			outDegree[i] = graph[i].length;
//			for (int to : graph[i]) {
//				map.computeIfAbsent(to, k -> new ArrayList<>()).add(i);
//			}
//		}
//		Queue<Integer> queue = new LinkedList<>();
//		for (int i = 0; i < n; i++) {
//			if (outDegree[i] == 0) {
//				queue.offer(i);
//			}
//		}
//		while (!queue.isEmpty()) {
//			for (int i = queue.size(); i >= 0; i--) {
//				Integer node = queue.poll();
//				if (map.containsKey(node)) {
//					for (Integer prev : map.get(node)) {
//						if (--outDegree[prev] == 0) {
//							queue.offer(prev);
//						}
//					}
//				}
//			}
//		}
//		List<Integer> res = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			if (outDegree[i] == 0) {
//				res.add(i);
//			}
//		}
//		return res;
//	}
}
