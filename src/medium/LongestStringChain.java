package medium;

import java.util.*;

public class LongestStringChain {
	
	public static void main(String[] args) {
		int res = longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"});
		System.out.println(res);
	}
	
	public static int longestStrChain(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String::length));
		Map<String, Integer> map = new HashMap<>();
		int res = 0;
		for (String word : words) {
			int max = 1;
			for (int i = 0; i < word.length(); i++) {
				String prevWord = word.substring(0, i) + word.substring(i + 1);
				max = Math.max(max, map.getOrDefault(prevWord, 0) + 1);
			}
			res = Math.max(res, max);
			map.put(word, max);
		}
		return res;
	}
}
