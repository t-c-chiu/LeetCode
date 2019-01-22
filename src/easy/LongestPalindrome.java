package easy;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

	public static void main(String[] args) {
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
		System.out.println(longestPalindrome.longestPalindrome("abcde"));
		System.out.println(longestPalindrome.longestPalindrome("aabbbcc"));
	}

	//	In: "abccccdd"
	//	Out: 7
	//	"dccaccd"
	public int longestPalindrome(String s) {
		int count = 0;
		Set<Character> set = new HashSet<>();
		for (Character c : s.toCharArray()) {
			if (set.contains(c)) {
				set.remove(c);
				count++;
			} else
				set.add(c);
		}
		return set.isEmpty() ? count * 2 : count * 2 + 1;
	}
}
