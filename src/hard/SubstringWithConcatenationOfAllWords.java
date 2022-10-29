package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	
	public static void main(String[] args) {
		List<Integer> res = findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
		System.out.println(res);
	}
	
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int n = s.length(), m = words.length, wordLen = words[0].length();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		for (int i = 0; i <= n - m * wordLen; i++) {
			if (isValid(s.substring(i, i + m * wordLen), map, wordLen)) {
				res.add(i);
			}
		}
		return res;
	}
	
	private static boolean isValid(String s, Map<String, Integer> map, int wordLen) {
		Map<String, Integer> seen = new HashMap<>();
		for (int i = 0; i < s.length(); i += wordLen) {
			String sub = s.substring(i, i + wordLen);
			if (seen.getOrDefault(sub, 0) < map.getOrDefault(sub, 0)) {
				seen.put(sub, seen.getOrDefault(sub, 0) + 1);
			} else {
				return false;
			}
		}
		return true;
	}
}
