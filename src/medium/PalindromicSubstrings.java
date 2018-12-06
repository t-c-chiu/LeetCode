package medium;

public class PalindromicSubstrings {
	public static void main(String[] args) {
		PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
//		System.out.println(palindromicSubstrings.countSubstrings("abc"));
//		System.out.println(palindromicSubstrings.countSubstrings("aaa"));
		System.out.println(palindromicSubstrings.countSubstrings("abbccbba"));
	}

	//Example 1:
	//	Input: "abc"
	//	Output: 3
	//	Explanation: Three palindromic strings: "a", "b", "c".
	//Example 2:
	//	Input: "aaa"
	//	Output: 6
	//	Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
	private char[] chars;
	private int count;

	public int countSubstrings(String s) {
		chars = s.toCharArray();
		count = 0;
		for (int i = 0; i < chars.length; i++) {
			count++;
			checkPalindromic(i, i + 1);
			checkPalindromic(i - 1, i + 1);
		}
		return count;
	}

	private void checkPalindromic(int i, int j) {
		if (i < 0 || j >= chars.length)
			return;

		if (chars[i] == chars[j]) {
			count++;
			checkPalindromic(i - 1, j + 1);
		}
	}
}
