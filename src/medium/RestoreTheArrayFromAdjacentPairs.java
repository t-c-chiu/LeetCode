package medium;

import java.util.*;

public class RestoreTheArrayFromAdjacentPairs {
	
	public static void main(String[] args) {
		int[] res = restoreArray(new int[][]{
				{4, -2}, {1, 4}, {-3, 1}
		});
		Arrays.stream(res).forEach(i -> System.out.print(i + " "));
	}
	
	public static int[] restoreArray(int[][] adjacentPairs) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] pair : adjacentPairs) {
			int num1 = pair[0];
			int num2 = pair[1];
			graph.putIfAbsent(num1, new ArrayList<>());
			graph.putIfAbsent(num2, new ArrayList<>());
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}
		int[] res = new int[graph.size()];
		for (int key : graph.keySet()) {
			if (graph.get(key).size() == 1) {
				dfs(graph, res, key, 0, new HashSet<>());
				break;
			}
		}
		return res;
	}
	
	private static void dfs(Map<Integer, List<Integer>> map, int[] res, Integer num, int i, Set<Integer> used) {
		res[i] = num;
		used.add(num);
		for (int next : map.get(num)) {
			if (!used.contains(next)) {
				dfs(map, res, next, i + 1, used);
			}
		}
	}
}
