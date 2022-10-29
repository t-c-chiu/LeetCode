package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	
	public static void main(String[] args) {
		int res = lengthOfLongestSubstringTwoDistinct("aaaaacb");
		System.out.println(res);
	}
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int res = 0;
		for (int r = 0, l = 0; r < s.length(); r++) {
			char rc = s.charAt(r);
			map.put(rc, map.getOrDefault(rc, 0) + 1);
			while (map.size() > 2) {
				char lc = s.charAt(l);
				map.put(lc, map.get(lc) - 1);
				map.remove(lc, 0);
				l++;
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
