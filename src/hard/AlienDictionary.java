package hard;

import java.util.*;

public class AlienDictionary {
	
	public static void main(String[] args) {
		String res = alienOrder(new String[]{"z", "x", "a", "zb", "zx"});
		System.out.println(res);
	}
	
	public static String alienOrder(String[] words) {
		Map<Character, Set<Character>> map = new HashMap<>();
		Map<Character, Integer> inDegree = new HashMap<>();
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				inDegree.put(word.charAt(i), 0);
			}
		}
		for (int i = 1; i < words.length; i++) {
			String prev = words[i - 1];
			String cur = words[i];
			if (prev.length() > cur.length() && prev.startsWith(cur)) {
				return "";
			}
			for (int j = 0; j < Math.min(prev.length(), cur.length()); j++) {
				char c1 = prev.charAt(j);
				char c2 = cur.charAt(j);
				if (c1 != c2) {
					map.putIfAbsent(c1, new HashSet<>());
					if (!map.get(c1).contains(c2)) {
						map.get(c1).add(c2);
						inDegree.put(c2, inDegree.get(c2) + 1);
					}
					break;
				}
			}
		}
		Queue<Character> queue = new LinkedList<>();
		for (Character c : inDegree.keySet()) {
			if (inDegree.get(c) == 0) {
				queue.offer(c);
			}
		}
		StringBuilder builder = new StringBuilder();
		while (!queue.isEmpty()) {
			Character c = queue.poll();
			builder.append(c);
			if (map.containsKey(c)) {
				for (Character next : map.get(c)) {
					inDegree.put(next, inDegree.get(next) - 1);
					if (inDegree.get(next) == 0) {
						queue.offer(next);
					}
				}
			}
		}
		
		return builder.length() == inDegree.size() ? builder.toString() : "";
	}
}
