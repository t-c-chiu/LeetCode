package medium;

import java.util.*;

public class FindAndReplacePattern {
	
	public static void main(String[] args) {
		FindAndReplacePattern test = new FindAndReplacePattern();
		test.findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb")
				.forEach(System.out::println);
	}
	
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> res = new ArrayList<>();
		int[] normalizedPattern = normalize(pattern);
		for (String word : words) {
			if (Arrays.equals(normalizedPattern, normalize(word)))
				res.add(word);
		}
		return res;
	}
	
	private int[] normalize(String pattern) {
		Map<Character, Integer> map = new HashMap<>();
		int len = pattern.length();
		int[] res = new int[len];
		for (int i = 0, j = 0; i < len; i++) {
			final char c = pattern.charAt(i);
			map.putIfAbsent(c, j++);
			res[i] = map.get(c);
		}
		return res;
	}
}
