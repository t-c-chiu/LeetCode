package hard;

import java.util.*;

public class BusRoutes {
	
	public static void main(String[] args) {
		int res = numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6);
		System.out.println(res);
	}
	
	public static int numBusesToDestination(int[][] routes, int source, int target) {
		if (source == target) {
			return 0;
		}
		int n = routes.length;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int stop : routes[i]) {
				map.putIfAbsent(stop, new HashSet<>());
				map.get(stop).add(i);
			}
		}
		if (!map.containsKey(source) || !map.containsKey(target)) {
			return -1;
		}
		Set<Integer> seenRoute = new HashSet<>();
		Set<Integer> seenStop = new HashSet<>();
		seenStop.add(source);
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		int res = 0;
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				Integer stop = queue.poll();
				if (stop == target) {
					return res;
				}
				for (Integer route : map.get(stop)) {
					if (seenRoute.contains(route)) {
						continue;
					}
					for (int next : routes[route]) {
						if (seenStop.contains(next)) {
							continue;
						}
						queue.offer(next);
						seenStop.add(next);
					}
					seenRoute.add(route);
				}
			}
			res++;
		}
		return -1;
	}
	
}
