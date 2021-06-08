package easy;

public class ValidPalindromeII {
	
	public static void main(String[] args) {
		boolean res = validPalindrome("acccacccabb");
		System.out.println(res);
	}
	
	public static boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right && s.charAt(left) == s.charAt(right)) {
			left++;
			right--;
		}
		return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
	}
	
	private static boolean validPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
