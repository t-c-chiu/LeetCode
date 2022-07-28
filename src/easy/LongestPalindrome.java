package easy;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd"));
		System.out.println(longestPalindrome("abcde"));
		System.out.println(longestPalindrome("aabbbcc"));
	}
	
	public static int longestPalindrome(String s) {
		Set<Character> set = new HashSet<>();
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				set.remove(c);
				res += 2;
			} else {
				set.add(c);
			}
		}
		return set.isEmpty() ? res : res + 1;
	}
}
