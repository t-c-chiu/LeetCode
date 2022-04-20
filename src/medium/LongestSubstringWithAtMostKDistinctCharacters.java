package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
	
	public static void main(String[] args) {
		int res = lengthOfLongestSubstringKDistinct("aabbbcbbc", 2);
		System.out.println(res);
	}
	
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int res = 0, l = 0, r = 0;
		while (r < s.length()) {
			char c = s.charAt(r);
			map.put(c, map.getOrDefault(c, 0) + 1);
			while (map.size() > k) {
				c = s.charAt(l);
				map.put(c, map.get(c) - 1);
				map.remove(c, 0);
				l++;
			}
			r++;
			res = Math.max(res, r - l);
		}
		return res;
	}
}
