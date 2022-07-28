package medium;

import java.util.*;

public class NetworkDelayTime {
	
	public static void main(String[] args) {
		int res = networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1);
		System.out.println(res);
	}
	
	public static int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, List<int[]>> g = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			g.put(i, new ArrayList<>());
		}
		for (int[] time : times) {
			g.get(time[0]).add(new int[]{time[1], time[2]});
		}
		Set<Integer> seen = new HashSet<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[]{k, 0});
		int res = 0;
		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			int node = poll[0], time = poll[1];
			if (seen.contains(node)) {
				continue;
			}
			seen.add(node);
			res = time;
			for (int[] next : g.get(node)) {
				pq.offer(new int[]{next[0], time + next[1]});
			}
		}
		return seen.size() == n ? res : -1;
	}

//	public static int networkDelayTime(int[][] times, int n, int k) {
//		int[][] dis = new int[n][n];
//		for (int i = 0; i < dis.length; i++) {
//			Arrays.fill(dis[i], 101);
//			dis[i][i] = 0;
//		}
//
//		for (int[] time : times) {
//			dis[time[0] - 1][time[1] - 1] = time[2];
//		}
//
//		for (int a = 0; a < n; a++) {
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					dis[i][j] = Math.min(dis[i][j], dis[i][a] + dis[a][j]);
//				}
//			}
//		}
//
//		int res = -1;
//		for (int t : dis[k - 1]) {
//			if (t == 101) {
//				return -1;
//			}
//			res = Math.longest(res, t);
//		}
//		return res;
//	}
	
}
