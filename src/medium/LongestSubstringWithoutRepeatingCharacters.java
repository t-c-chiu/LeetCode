package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring(" "));
		System.out.println(lengthOfLongestSubstring("bbbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int res = 0;
		for (int r = 0, l = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			while (set.contains(c)) {
				set.remove(s.charAt(l++));
			}
			set.add(c);
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
