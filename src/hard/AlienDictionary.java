package hard;

import java.util.*;

public class AlienDictionary {
	
	public static void main(String[] args) {
		String res = alienOrder(new String[]{"ac", "ab", "zc", "zb"});
		System.out.println(res);
	}
	
	public static String alienOrder(String[] words) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		Map<Character, Integer> inDegree = new HashMap<>();
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				graph.putIfAbsent(c, new HashSet<>());
				inDegree.put(c, 0);
			}
		}
		for (int i = 1; i < words.length; i++) {
			String prev = words[i - 1], cur = words[i];
			if (prev.equals(cur) || cur.startsWith(prev)) {
				continue;
			}
			if (prev.startsWith(cur)) {
				return "";
			}
			int j = 0;
			while (j < Math.min(prev.length(), cur.length()) && prev.charAt(j) == cur.charAt(j)) {
				j++;
			}
			char c = cur.charAt(j);
			if (!graph.get(prev.charAt(j)).contains(c)) {
				graph.get(prev.charAt(j)).add(c);
				inDegree.put(c, inDegree.get(c) + 1);
			}
		}
		Queue<Character> queue = new LinkedList<>();
		for (Character c : inDegree.keySet()) {
			if (inDegree.get(c) == 0) {
				queue.offer(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			Character c = queue.poll();
			sb.append(c);
			for (Character next : graph.get(c)) {
				inDegree.put(next, inDegree.get(next) - 1);
				if (inDegree.get(next) == 0) {
					queue.offer(next);
				}
			}
		}
		return sb.length() == graph.size() ? sb.toString() : "";
	}
}
