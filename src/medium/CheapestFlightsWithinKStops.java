package medium;

import java.util.*;

public class CheapestFlightsWithinKStops {
	
	public static void main(String[] args) {
		int res = findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1);
		System.out.println(res);
	}
	
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		Map<Integer, Set<int[]>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<>());
		}
		for (int[] flight : flights) {
			int from = flight[0], to = flight[1], price = flight[2];
			graph.get(from).add(new int[]{to, price});
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[]{src, 0, 0});
		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			int city = poll[0], price = poll[1], stop = poll[2];
			if (city == dst) {
				return price;
			}
			if (stop <= k) {
				for (int[] next : graph.get(city)) {
					pq.offer(new int[]{next[0], price + next[1], stop + 1});
				}
			}
		}
		return -1;
	}
}
