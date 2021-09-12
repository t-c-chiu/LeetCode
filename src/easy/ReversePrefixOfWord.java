package easy;

public class ReversePrefixOfWord {
	public static void main(String[] args) {
		String res = reversePrefix("abcdefd", 'z');
		System.out.println(res);
	}
	
	public static String reversePrefix(String word, char ch) {
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ch) {
				reverse(chars, 0, i);
				return String.valueOf(chars);
			}
		}
		return word;
	}
	
	private static void reverse(char[] chars, int i, int j) {
		while (i < j) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		}
	}
}
