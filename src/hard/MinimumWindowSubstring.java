package hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		String res = minWindow("ADOBECODEBANC", "ABC");
		System.out.println(res);
	}
	
	public static String minWindow(String s, String t) {
		int m = s.length(), n = t.length();
		if (n > m) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = t.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int count = map.size(), max = Integer.MAX_VALUE;
		String res = "";
		for (int right = 0, left = 0; right < m; right++) {
			char c = s.charAt(right);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) {
					count--;
				}
				while (count == 0) {
					if (right - left + 1 < max) {
						max = right - left + 1;
						res = s.substring(left, right + 1);
					}
					c = s.charAt(left);
					if (map.containsKey(c)) {
						map.put(c, map.get(c) + 1);
						if (map.get(c) > 0) {
							count++;
						}
					}
					left++;
				}
			}
		}
		return res;
	}
}
