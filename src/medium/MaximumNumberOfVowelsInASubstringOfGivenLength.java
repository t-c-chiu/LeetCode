package medium;

import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
	
	public static void main(String[] args) {
		int res = maxVowels("leetcode", 2);
		System.out.println(res);
	}
	
	public static int maxVowels(String s, int k) {
		Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
		int res = 0, vowelCount = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (vowels.contains(s.charAt(i))) {
				vowelCount++;
			}
			if (i - j + 1 > k) {
				if (vowels.contains(s.charAt(j++))) {
					vowelCount--;
				}
			}
			if (i - j + 1 == k) {
				res = Math.max(res, vowelCount);
			}
		}
		return res;
	}
}
