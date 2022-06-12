package medium;

import java.util.*;

public class TreeDiameter {
	
	public static void main(String[] args) {
		int res = treeDiameter(new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}});
		System.out.println(res);
	}
	
	public static int treeDiameter(int[][] edges) {
		int n = edges.length + 1;
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
		int res = 0;
		while (n > 2) {
			res++;
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
		return n == 1 ? res * 2 : res * 2 + 1;
	}
}
