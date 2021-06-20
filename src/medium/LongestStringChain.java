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
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int longest = 1;
			for (int j = 0; j < word.length(); j++) {
				String prev = word.substring(0, j) + word.substring(j + 1);
				longest = Math.max(longest, map.getOrDefault(prev, 0) + 1);
			}
			map.put(word, longest);
			res = Math.max(res, longest);
		}
		return res;
	}
}
