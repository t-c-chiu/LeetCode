package medium;

public class ReverseWordsInAStringII {
	
	public static void main(String[] args) {
		char[] chars = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
		reverseWords(chars);
		for (char c : chars) {
			System.out.print(c);
		}
	}
	
	/**
	 * eulb si yks eht
	 * blue is sky the
	 */
	public static void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1);
		int start = 0;
		for (int i = 0; i < s.length; i++) {
			if (i == s.length - 1 || s[i + 1] == ' ') {
				reverse(s, start, i);
				start = i + 2;
			}
		}
	}
	
	private static void reverse(char[] s, int left, int right) {
		while (left < right) {
			swap(s, left, right);
			left++;
			right--;
		}
	}
	
	private static void swap(char[] s, int left, int right) {
		char tmp = s[left];
		s[left] = s[right];
		s[right] = tmp;
	}
}
