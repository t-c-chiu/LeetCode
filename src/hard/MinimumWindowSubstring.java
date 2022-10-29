package hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		String res = minWindow("ADOBECODEBANC", "ABC");
		System.out.println(res);
	}
	
	public static String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		String res = "";
		int count = t.length();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int r = 0, l = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) >= 0) {
					count--;
				}
			}
			while (count == 0) {
				if (res.isEmpty() || r - l + 1 < res.length()) {
					res = s.substring(l, r + 1);
				}
				c = s.charAt(l);
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
					if (map.get(c) > 0) {
						count++;
					}
				}
				l++;
			}
		}
		return res;
	}
}
