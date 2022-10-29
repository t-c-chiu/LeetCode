package medium;

public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		String res = longestPalindrome("babad");
		System.out.println(res);
	}
	
	static int start, len;
	
	public static String longestPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			extend(s, i, i);
			if (i > 0) {
				extend(s, i - 1, i);
			}
		}
		return s.substring(start, start + len);
	}
	
	private static void extend(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if (right - left - 1 > len) {
			start = left + 1;
			len = right - left - 1;
		}
	}
}
