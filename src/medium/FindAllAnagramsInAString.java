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
		if (s.length() < p.length()) {
			return res;
		}
		int n = p.length();
		int[] count = new int[26];
		for (int i = 0; i < n; i++) {
			count[p.charAt(i) - 'a']++;
		}
		for (int r = 0, l = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			count[c - 'a']--;
			if (count[c - 'a'] >= 0) {
				n--;
			}
			if (r - l + 1 > p.length()) {
				char lc = s.charAt(l);
				count[lc - 'a']++;
				if (count[lc - 'a'] > 0) {
					n++;
				}
				l++;
			}
			if (n == 0) {
				res.add(l);
			}
		}
		return res;
	}
}
