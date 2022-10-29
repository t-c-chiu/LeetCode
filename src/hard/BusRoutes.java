package hard;

import java.util.*;

public class BusRoutes {
	
	public static void main(String[] args) {
		int res = numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6);
		System.out.println(res);
	}
	
	public static int numBusesToDestination(int[][] routes, int source, int target) {
		Map<Integer, Set<Integer>> stopToBus = new HashMap<>();
		for (int i = 0; i < routes.length; i++) {
			for (int stop : routes[i]) {
				stopToBus.putIfAbsent(stop, new HashSet<>());
				stopToBus.get(stop).add(i);
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> seenStop = new HashSet<>();
		Set<Integer> seenBus = new HashSet<>();
		queue.offer(source);
		seenStop.add(source);
		int res = 0;
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				int stop = queue.poll();
				if (stop == target) {
					return res;
				}
				for (Integer bus : stopToBus.get(stop)) {
					if (seenBus.contains(bus)) {
						continue;
					}
					seenBus.add(bus);
					for (int nextStop : routes[bus]) {
						if (seenStop.contains(nextStop)){
							continue;
						}
						seenStop.add(nextStop);
						queue.offer(nextStop);
					}
				}
			}
			res++;
		}
		return -1;
	}
}
