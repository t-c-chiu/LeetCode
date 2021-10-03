package medium;

public class BreakAPalindrome {
	
	public static void main(String[] args) {
		String res = breakPalindrome("cabac");
		System.out.println(res);
	}
	
	public static String breakPalindrome(String palindrome) {
		char[] chars = palindrome.toCharArray();
		int n = chars.length;
		if (n == 1) {
			return "";
		}
		for (int i = 0; i < n / 2; i++) {
			if (chars[i] != 'a') {
				chars[i] = 'a';
				return new String(chars);
			}
		}
		chars[n - 1] = 'b';
		return new String(chars);
	}
	/**
	 * a
	 * aa -> ab
	 * aba -> abb
	 * abba -> aaba
	 * aaaaa -> aaaab
	 * aabaa -> aabab
	 * abbba -> aabba
	 * ccccc -> acccc
	 * cabac -> aabac
	 */
//	public static String breakPalindrome(String palindrome) {
//		char[] chars = palindrome.toCharArray();
//		int n = chars.length;
//		if (n == 1) {
//			return "";
//		}
//
//		int aCount = 0;
//		for (int i = 0; i < n; i++) {
//			if (chars[i] == 'a') {
//				aCount++;
//			}
//		}
//
//		if (aCount >= n - 1) {
//			for (int i = n - 1; i >= 0; i--) {
//				if (chars[i] == 'a') {
//					chars[i] = 'b';
//					break;
//				}
//			}
//		} else {
//			for (int i = 0; i < n; i++) {
//				if (chars[i] != 'a') {
//					chars[i] = 'a';
//					break;
//				}
//			}
//		}
//
//		return new String(chars);
//	}
}
