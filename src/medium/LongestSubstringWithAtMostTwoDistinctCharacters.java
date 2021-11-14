package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	
	public static void main(String[] args) {
		int res = lengthOfLongestSubstringTwoDistinct("aaaaacb");
		System.out.println(res);
	}
	
	/**
	 * ccaabbb
	 */
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int left = 0, right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			map.put(c, map.getOrDefault(c, 0) + 1);
			while (map.size() > 2) {
				char lc = s.charAt(left);
				map.put(lc, map.get(lc) - 1);
				if (map.get(lc) == 0) {
					map.remove(lc);
				}
				left++;
			}
			res = Math.max(res, right - left + 1);
		}
		return res;
	}
}
