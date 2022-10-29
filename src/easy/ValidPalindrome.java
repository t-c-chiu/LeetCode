package easy;

public class ValidPalindrome {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
	
	public static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			while (left < right && !isAlphanumeric(s.charAt(left))) {
				left++;
			}
			while (left < right && !isAlphanumeric(s.charAt(right))) {
				right--;
			}
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	private static boolean isAlphanumeric(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}
}
