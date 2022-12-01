package medium;

import java.util.*;

public class LongestStringChain {
	
	public static void main(String[] args) {
		int res = longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"});
		System.out.println(res);
	}
	
	public static int longestStrChain(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String::length));
		Map<String, Integer> map = new HashMap<>();
		int res = 0;
		for (String word : words) {
			int max = 0;
			for (int i = 0; i < word.length(); i++) {
				String prev = word.substring(0, i) + word.substring(i + 1);
				max = Math.max(max, map.getOrDefault(prev, 0) + 1);
			}
			map.put(word, max);
			res = Math.max(res, max);
		}
		return res;
	}
	
}
