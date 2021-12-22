package medium;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
	
	public static void main(String[] args) {
		int res = minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}});
		System.out.println(res);
	}
	
	public static int minReorder(int n, int[][] connections) {
		List<Integer>[] lists = new List[n];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new ArrayList<>();
		}
		for (int[] c : connections) {
			lists[c[0]].add(c[1]);
			lists[c[1]].add(-c[0]);
		}
		return dfs(lists, new boolean[n], 0);
	}
	
	private static int dfs(List<Integer>[] lists, boolean[] visited, int from) {
		int change = 0;
		visited[from] = true;
		for (Integer to : lists[from]) {
			if (!visited[Math.abs(to)]) {
				change += dfs(lists, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
			}
		}
		return change;
	}
}
