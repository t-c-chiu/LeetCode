package medium;

import java.util.*;

public class MinimumHeightTrees {
	
	public static void main(String[] args) {
		List<Integer> res = findMinHeightTrees(4, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
		System.out.println(res);
	}
	
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) {
			return Collections.singletonList(0);
		}
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
			map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
		}
		Queue<Integer> leaves = new LinkedList<>();
		for (Integer node : map.keySet()) {
			if (map.get(node).size() == 1) {
				leaves.offer(node);
			}
		}
		while (n > 2) {
			int size = leaves.size();
			n -= size;
			for (int i = 0; i < size; i++) {
				Integer leaf = leaves.poll();
				Integer next = map.get(leaf).iterator().next();
				map.get(next).remove(leaf);
				if (map.get(next).size() == 1) {
					leaves.offer(next);
				}
			}
		}
		return leaves.stream().toList();
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
