package easy;

public class ReverseOnlyLetters {
	
	public static void main(String[] args) {
		String res = reverseOnlyLetters("Test1ng-Leet=code-Q!");
		System.out.println(res);
	}
	
	public static String reverseOnlyLetters(String s) {
		int left = 0, right = s.length() - 1;
		char[] chars = s.toCharArray();
		while (left < right) {
			while (left < right && !Character.isLetter(chars[left])) {
				left++;
			}
			while (left < right && !Character.isLetter(chars[right])) {
				right--;
			}
			swap(chars, left, right);
			left++;
			right--;
		}
		return String.valueOf(chars);
	}
	
	private static void swap(char[] chars, int left, int right) {
		char temp = chars[left];
		chars[left] = chars[right];
		chars[right] = temp;
	}
}
