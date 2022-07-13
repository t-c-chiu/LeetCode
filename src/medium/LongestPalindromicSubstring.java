package medium;

public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		String res = longestPalindrome("babad");
		System.out.println(res);
	}
	
	static int start;
	static int maxLen;
	
	public static String longestPalindrome(String s) {
		int n = s.length();
		for (int i = 0; i < n; i++) {
			extendPalindrome(i, i, s);
			if (i + 1 < n) {
				extendPalindrome(i, i + 1, s);
			}
		}
		return s.substring(start, start + maxLen);
	}
	
	private static void extendPalindrome(int left, int right, String s) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if (right - left - 1 > maxLen) {
			start = left + 1;
			maxLen = right - left - 1;
		}
	}
}
