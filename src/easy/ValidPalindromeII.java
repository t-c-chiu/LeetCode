package easy;

public class ValidPalindromeII {
	
	public static void main(String[] args) {
		boolean res = validPalindrome("acccacccabb");
		System.out.println(res);
	}
	
	public static boolean validPalindrome(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r && s.charAt(l) == s.charAt(r)) {
			l++;
			r--;
		}
		return validPalindrome(s, l + 1, r) || validPalindrome(s, l, r - 1);
	}
	
	private static boolean validPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	
}
