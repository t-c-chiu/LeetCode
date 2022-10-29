package medium;

import java.util.*;

public class MinimumHeightTrees {
	
	public static void main(String[] args) {
		List<Integer> res = findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
		System.out.println(res);
	}
	
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) {
			return List.of(0);
		}
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new HashSet<>());
			graph.putIfAbsent(edge[1], new HashSet<>());
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		Queue<Integer> leaves = new LinkedList<>();
		for (Integer node : graph.keySet()) {
			if (graph.get(node).size() == 1) {
				leaves.offer(node);
			}
		}
		while (!leaves.isEmpty() && n > 2) {
			for (int i = leaves.size(); i > 0; i--) {
				Integer cur = leaves.poll();
				n--;
				for (Integer next : graph.get(cur)) {
					graph.get(next).remove(cur);
					if (graph.get(next).size() == 1) {
						leaves.offer(next);
					}
				}
			}
		}
		return new ArrayList<>(leaves);
	}

//	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
//		if (n == 1) {
//			return Collections.singletonList(0);
//		}
//
//		Map<Integer, List<Integer>> map = new HashMap<>();
//		Map<Integer, Integer> inDegree = new HashMap<>();
//		for (int[] edge : edges) {
//			map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
//			map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
//			inDegree.put(edge[0], inDegree.getOrDefault(edge[0], 0) + 1);
//			inDegree.put(edge[1], inDegree.getOrDefault(edge[1], 0) + 1);
//		}
//		Queue<Integer> queue = new LinkedList<>();
//		for (Integer node : inDegree.keySet()) {
//			if (inDegree.get(node) == 1) {
//				queue.offer(node);
//			}
//		}
//		while (n > 2) {
//			int size = queue.size();
//			n -= size;
//			for (int i = 0; i < size; i++) {
//				Integer node = queue.poll();
//				for (Integer next : map.get(node)) {
//					inDegree.put(next, inDegree.get(next) - 1);
//					if (inDegree.get(next) == 1) {
//						queue.offer(next);
//					}
//				}
//			}
//		}
//		return queue.stream().toList();
//	}
}
