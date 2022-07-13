package easy;

public class ValidPalindrome {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
	
	public static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}
			if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
