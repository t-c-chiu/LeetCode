package easy;

public class ReverseVowelsOfAString {
	
	public static void main(String[] args) {
		ReverseVowelsOfAString test = new ReverseVowelsOfAString();
		System.out.println(test.reverseVowels("hello"));
		System.out.println(test.reverseVowels("leetcode"));
	}
	
	public String reverseVowels(String s) {
		char[] chars = s.toCharArray();
		int left = 0, right = chars.length - 1;
		while (left < right) {
			while (left < right && !isVowels(chars[left]))
				left++;
			while (left < right && !isVowels(chars[right]))
				right--;
			swap(chars, left, right);
			left++;
			right--;
		}
		return new String(chars);
	}
	
	private boolean isVowels(char c) {
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
				c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	private void swap(char[] chars, int left, int right) {
		char tmp = chars[left];
		chars[left] = chars[right];
		chars[right] = tmp;
	}
}
