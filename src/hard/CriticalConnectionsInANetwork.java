package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {
	
	public static void main(String[] args) {
		List<List<Integer>> res = criticalConnections(4, Arrays.asList(
				Arrays.asList(0, 1),
				Arrays.asList(1, 2),
				Arrays.asList(2, 0),
				Arrays.asList(1, 3)
		));
		System.out.println(res);
	}
	
	static int time = 1;
	
	public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<Integer>[] graph = new List[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (List<Integer> connection : connections) {
			int from = connection.get(0), to = connection.get(1);
			graph[from].add(to);
			graph[to].add(from);
		}
		List<List<Integer>> res = new ArrayList<>();
		int[] timestamp = new int[n];
		dfs(res, graph, timestamp, 0, -1);
		return res;
	}
	
	private static int dfs(List<List<Integer>> res, List<Integer>[] graph, int[] timestamp, int i, int p) {
		if (timestamp[i] != 0) {
			return timestamp[i];
		}
		timestamp[i] = time++;
		int minTime = Integer.MAX_VALUE;
		for (Integer next : graph[i]) {
			if (next == p) {
				continue;
			}
			int nextTime = dfs(res, graph, timestamp, next, i);
			minTime = Math.min(minTime, nextTime);
		}
		if (minTime >= timestamp[i] && p >= 0) {
			res.add(Arrays.asList(i, p));
		}
		return Math.min(timestamp[i], minTime);
	}
}
