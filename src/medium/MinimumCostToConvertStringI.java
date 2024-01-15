package medium;

import java.util.*;

public class MinimumCostToConvertStringI {
	
	public static void main(String[] args) {
		long res = minimumCost("abcd", "acbe",
				new char[]{'a', 'b', 'c', 'c', 'e', 'd'}, new char[]{'b', 'c', 'b', 'e', 'b', 'e'}, new int[]{2, 5, 5, 1, 2, 20});
		System.out.println(res);
	}
	
	public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
		long res = 0;
		Map<Character, Map<Character, Integer>> map = new HashMap<>();
		for (int i = 0; i < original.length; i++) {
			char from = original[i], to = changed[i];
			int c = cost[i];
			map.putIfAbsent(from, new HashMap<>());
			int oriCost = map.get(from).getOrDefault(to, Integer.MAX_VALUE);
			map.get(from).put(to, Math.min(c, oriCost));
		}
		Map<Character, Map<Character, Long>> cache = new HashMap<>();
		for (int i = 0; i < source.length(); i++) {
			char from = source.charAt(i), to = target.charAt(i);
			if (cache.containsKey(from) && cache.get(from).containsKey(to)) {
				res += cache.get(from).get(to);
				continue;
			}
			long temp = bfs(source.charAt(i), target.charAt(i), map);
			if (temp == -1) {
				return -1;
			}
			cache.putIfAbsent(from, new HashMap<>());
			cache.get(from).put(to, temp);
			res += temp;
		}
		return res;
	}
	
	private static long bfs(char from, char to, Map<Character, Map<Character, Integer>> map) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.cost));
		pq.offer(new Pair(from, 0));
		Set<Character> seen = new HashSet<>();
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			if (pair.c == to) {
				return pair.cost;
			}
			if (seen.contains(pair.c)) {
				continue;
			}
			seen.add(pair.c);
			if (!map.containsKey(pair.c)) {
				continue;
			}
			Map<Character, Integer> neighbors = map.get(pair.c);
			for (Character next : neighbors.keySet()) {
				if (seen.contains(next)) {
					continue;
				}
				pq.offer(new Pair(next, pair.cost + neighbors.get(next)));
			}
		}
		return -1;
	}
	
	static class Pair {
		char c;
		int cost;
		
		public Pair(char c, int cost) {
			this.c = c;
			this.cost = cost;
		}
	}
	
}
