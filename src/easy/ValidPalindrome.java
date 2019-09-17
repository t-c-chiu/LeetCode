package easy;

public class ValidPalindrome {
	
	public static void main(String[] args) {
		ValidPalindrome test = new ValidPalindrome();
		System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(test.isPalindrome("race a car"));
	}
	
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int left = 0, right = s.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
				left++;
			while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
				right--;
			
			if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right)))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
