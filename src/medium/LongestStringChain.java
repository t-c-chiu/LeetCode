package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
	
	public static void main(String[] args) {
		int res = longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"});
		System.out.println(res);
	}
	
	static public int longestStrChain(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String::length));
		Map<String, Integer> map = new HashMap<>();
		int res = 0;
		for (String word : words) {
			int best = 0;
			for (int i = 0; i < word.length(); i++) {
				String prev = word.substring(0, i) + word.substring(i + 1);
				best = Math.max(best, map.getOrDefault(prev, 0) + 1);
			}
			map.put(word, best);
			res = Math.max(res, best);
		}
		return res;
	}
}
