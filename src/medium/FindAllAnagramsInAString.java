package medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (p.length() > s.length()) {
			return res;
		}
		int[] count = new int[26];
		int diff = p.length();
		for (int i = 0; i < p.length(); i++) {
			count[p.charAt(i) - 'a']++;
		}
		for (int r = 0, l = 0; r < s.length(); r++) {
			if (--count[s.charAt(r) - 'a'] >= 0) {
				diff--;
			}
			if (r - l + 1 > p.length()) {
				if (++count[s.charAt(l++) - 'a'] > 0) {
					diff++;
				}
			}
			if (diff == 0) {
				res.add(l);
			}
		}
		return res;
	}
}
