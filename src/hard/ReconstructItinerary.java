package hard;

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
			map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
			map.get(ticket.get(0)).add(ticket.get(1));
		}
		List<String> res = new ArrayList<>();
		helper(res, map, "JFK");
		return res;
	}
	
	private static void helper(List<String> res, Map<String, PriorityQueue<String>> map, String from) {
		while (map.containsKey(from) && !map.get(from).isEmpty()) {
			helper(res, map, map.get(from).poll());
		}
		res.add(0, from);
	}
}
