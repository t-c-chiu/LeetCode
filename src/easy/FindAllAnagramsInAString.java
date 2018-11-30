package easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
	public static void main(String[] args) {
		FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
		System.out.println(findAllAnagramsInAString.findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAllAnagramsInAString.findAnagrams("abab", "ab"));
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (p == null || p.length() == 0 || s == null || s.length() == 0)
			return result;

		int[] hash = new int[26];
		int left = 0, right = 0, counter = p.length();
		for (char c : p.toCharArray())
			hash[c - 'a']++;

		while (right < s.length()) {
			char rightChar = s.charAt(right);
			if (hash[rightChar - 'a'] > 0)
				counter--;
			hash[rightChar - 'a']--;
			right++;

			if (right - left == p.length()) {
				if (counter == 0)
					result.add(left);
				char leftChar = s.charAt(left);
				if (hash[leftChar - 'a'] >= 0)
					counter++;
				hash[leftChar - 'a']++;
				left++;
			}
		}

		return result;
	}
}
