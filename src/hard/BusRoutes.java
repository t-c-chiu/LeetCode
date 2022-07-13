package hard;

import java.util.*;

public class BusRoutes {
	
	public static void main(String[] args) {
		int res = numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6);
		System.out.println(res);
	}
	
	public static int numBusesToDestination(int[][] routes, int source, int target) {
		Map<Integer, Set<Integer>> g = new HashMap<>();
		for (int i = 0; i < routes.length; i++) {
			for (int stop : routes[i]) {
				g.putIfAbsent(stop, new HashSet<>());
				g.get(stop).add(i);
			}
		}
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> seenStop = new HashSet<>();
		Set<Integer> seenBus = new HashSet<>();
		q.offer(source);
		seenStop.add(source);
		int res = 0;
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				int stop = q.poll();
				if (stop == target) {
					return res;
				}
				for (Integer bus : g.get(stop)) {
					if (!seenBus.contains(bus)) {
						seenBus.add(bus);
						for (int next : routes[bus]) {
							if (!seenStop.contains(next)) {
								seenStop.add(next);
								q.offer(next);
							}
						}
					}
				}
			}
			res++;
		}
		return -1;
	}
}
