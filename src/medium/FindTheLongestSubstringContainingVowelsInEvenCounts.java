package medium;

import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstringContainingVowelsInEvenCounts {
	
	public static void main(String[] args) {
		int res = findTheLongestSubstring("elaatminicoworoep");
		System.out.println(res);
	}
	
	public static int findTheLongestSubstring(String s) {
		int res = 0, mask = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < s.length(); i++) {
			int j = "aeiou".indexOf(s.charAt(i));
			if (j != -1) {
				mask ^= 1 << j;
			}
			map.putIfAbsent(mask, i);
			res = Math.max(res, i - map.get(mask));
		}
		return res;
	}
}
