package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleBipartition {
	
	public static void main(String[] args) {
		boolean res = possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}});
		System.out.println(res);
	}
	
	public static boolean possibleBipartition(int n, int[][] dislikes) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int[] dislike : dislikes) {
			int p1 = dislike[0], p2 = dislike[1];
			map.get(p1).add(p2);
			map.get(p2).add(p1);
		}
		int[] group = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (!dfs(i, map, group, 1)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean dfs(int i, Map<Integer, List<Integer>> map, int[] group, int g) {
		if (group[i] != 0) {
			return true;
		}
		group[i] = g;
		for (Integer dislike : map.get(i)) {
			if (group[dislike] == g) {
				return false;
			}
			if (!dfs(dislike, map, group, g * -1)) {
				return false;
			}
		}
		return true;
	}
	
}
