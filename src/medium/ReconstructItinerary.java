package medium;

import java.util.*;

public class ReconstructItinerary {
	
	public static void main(String[] args) {
		List<String> res = findItinerary(Arrays.asList(
				Arrays.asList("JFK", "KUL"),
				Arrays.asList("JFK", "NRT"),
				Arrays.asList("NRT", "JFK")
		));
		System.out.println(res);
	}
	
	public static List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (List<String> ticket : tickets) {
			String from = ticket.get(0);
			String to = ticket.get(1);
			map.putIfAbsent(from, new PriorityQueue<>());
			PriorityQueue<String> queue = map.get(from);
			queue.offer(to);
		}
		
		List<String> res = new ArrayList<>();
		visit(res, "JFK", map);
		return res;
	}
	
	private static void visit(List<String> res, String from, Map<String, PriorityQueue<String>> map) {
		while (map.containsKey(from) && !map.get(from).isEmpty()) {
			visit(res, map.get(from).poll(), map);
		}
		res.add(0, from);
	}
}
