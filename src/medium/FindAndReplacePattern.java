package medium;

import java.util.*;

public class FindAndReplacePattern {
	
	public static void main(String[] args) {
		List<String> res = findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb");
		System.out.println(res);
	}
	
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> res = new ArrayList<>();
		for (String word : words) {
			if (isMatch(word, pattern)) {
				res.add(word);
			}
		}
		return res;
	}

	private static boolean isMatch(String word, String pattern) {
		int n = word.length();
		Map<Character, Character> map = new HashMap<>();
		Set<Character> used = new HashSet<>();
		for (int i = 0; i < n; i++) {
			char c1 = pattern.charAt(i), c2 = word.charAt(i);
			if (map.containsKey(c1) && map.get(c1) != c2 || !map.containsKey(c1) && used.contains(c2)) {
				return false;
			} else {
				map.put(c1, c2);
				used.add(c2);
			}
		}
		return true;
	}
}
