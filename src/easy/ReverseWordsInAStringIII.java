package easy;

public class ReverseWordsInAStringIII {
	public static void main(String[] args) {
		System.out.println(new ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest"));
	}

	public String reverseWords(String s) {
		String[] strings = s.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			builder.append(reverseString(strings[i]));
			if (i < strings.length - 1)
				builder.append(" ");
		}
		return builder.toString();
	}

	private char[] reverseString(String string) {
		char[] chars = string.toCharArray();
		int left = 0;
		int right = chars.length - 1;
		while (left < right) {
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}
		return chars;
	}
}
