package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumNumberOfOccurrencesOfASubstring {
	
	public static void main(String[] args) {
		int res = maxFreq("aababcaab", 2, 3, 4);
		System.out.println(res);
	}
	
	public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		int length = s.length();
		int res = 0;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i <= length - minSize; i++) {
			String sub = s.substring(i, i + minSize);
			if (isValid(sub, maxLetters)) {
				map.put(sub, map.getOrDefault(sub, 0) + 1);
				res = Math.max(res, map.get(sub));
			}
		}
		return res;
	}
	
	private static boolean isValid(String s, int maxLetters) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
			if (set.size() > maxLetters) {
				return false;
			}
		}
		return true;
	}
}
