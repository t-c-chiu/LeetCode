package medium;

import java.util.*;

public class TimeNeededToInformAllEmployees {
	
	public static void main(String[] args) {
		int res = numOfMinutes(15, 0, new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6}, new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0});
		System.out.println(res);
	}
	
	public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.putIfAbsent(i, new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			if (manager[i] != -1) {
				map.get(manager[i]).add(i);
			}
		}
		return dfs(map, headID, informTime);
	}
	
	private static int dfs(Map<Integer, List<Integer>> map, int id, int[] informTime) {
		if (informTime[id] == 0) {
			return 0;
		}
		int max = 0;
		for (Integer next : map.get(id)) {
			max = Math.max(max, dfs(map, next, informTime));
		}
		return max + informTime[id];
	}
}
