package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring(" "));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int res = 0;
		for (int i = 0, left = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			while (set.contains(c)) {
				set.remove(s.charAt(left++));
			}
			set.add(c);
			res = Math.max(res, set.size());
		}
		return res;
	}
}
