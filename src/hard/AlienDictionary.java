package hard;

import java.util.*;

public class AlienDictionary {
	
	public static void main(String[] args) {
		String res = alienOrder(new String[]{"z", "z"});
		System.out.println(res);
	}
	
	public static String alienOrder(String[] words) {
		Map<Character, List<Character>> g = new HashMap<>();
		Map<Character, Integer> inDegree = new HashMap<>();
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				inDegree.put(c, 0);
				g.putIfAbsent(c, new ArrayList<>());
			}
		}
		for (int i = 1; i < words.length; i++) {
			String prev = words[i - 1];
			String cur = words[i];
			if (prev.length() > cur.length() && prev.startsWith(cur)) {
				return "";
			}
			for (int j = 0; j < Math.min(prev.length(), cur.length()); j++) {
				char prevC = prev.charAt(j);
				char curC = cur.charAt(j);
				if (prevC != curC) {
					g.get(prevC).add(curC);
					inDegree.put(curC, inDegree.get(curC) + 1);
					break;
				}
			}
		}
		Queue<Character> q = new LinkedList<>();
		for (Character c : inDegree.keySet()) {
			if (inDegree.get(c) == 0) {
				q.offer(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			Character cur = q.poll();
			sb.append(cur);
			for (Character next : g.get(cur)) {
				inDegree.put(next, inDegree.get(next) - 1);
				if (inDegree.get(next) == 0) {
					q.offer(next);
				}
			}
		}
		return sb.length() == inDegree.size() ? sb.toString() : "";
	}
}
