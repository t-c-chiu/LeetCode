package medium;

import java.util.*;

public class NetworkDelayTime {
	
	public static void main(String[] args) {
		int res = networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1);
		System.out.println(res);
	}
	
	public static int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int[] time : times) {
			map.putIfAbsent(time[0], new HashMap<>());
			map.get(time[0]).put(time[1], time[2]);
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		queue.offer(new int[]{0, k});
		Set<Integer> seen = new HashSet<>();
		int res = 0;
		while (!queue.isEmpty()) {
			int[] data = queue.poll();
			int curDis = data[0];
			int curNode = data[1];
			if (seen.contains(curNode)) {
				continue;
			}
			seen.add(curNode);
			res = curDis;
			if (map.containsKey(curNode)) {
				Map<Integer, Integer> next = map.get(curNode);
				for (Integer to : next.keySet()) {
					queue.offer(new int[]{curDis + next.get(to), to});
				}
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
