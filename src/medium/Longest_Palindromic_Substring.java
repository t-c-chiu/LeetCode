package medium;

public class Longest_Palindromic_Substring {
	
	public static void main(String[] args) {
		Longest_Palindromic_Substring test = new Longest_Palindromic_Substring();
		String res = test.longestPalindrome("cbbdbbd");
		System.out.println(res);
	}
	
	private int maxLen;
	private int start;
	
	public String longestPalindrome(String s) {
		int length = s.length();
		for (int i = 0; i < length; i++) {
			extendPalindrome(s, i, i);
			if (i < length - 1) {
				extendPalindrome(s, i, i + 1);
			}
		}
		return s.substring(start, start + maxLen);
	}
	
	private void extendPalindrome(String s, int left, int right) {
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
