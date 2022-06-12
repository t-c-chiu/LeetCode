package medium;

import java.util.Arrays;

public class BoldWordsInString {
	
	public static void main(String[] args) {
		String res = boldWords(new String[]{"ab", "bc"}, "aabcd");
		System.out.println(res);
	}
	
	public static String boldWords(String[] words, String s) {
		int n = s.length();
		boolean[] bold = new boolean[n + 1];
		for (String word : words) {
			int from = 0;
			while (s.indexOf(word, from) != -1) {
				int start = s.indexOf(word, from);
				Arrays.fill(bold, start, start + word.length(), true);
				from = start + 1;
			}
		}
		StringBuilder builder = new StringBuilder(bold[0] ? "<b>" : "");
		for (int i = 0; i < n; i++) {
			builder.append(s.charAt(i));
			if (!bold[i] && bold[i + 1]) {
				builder.append("<b>");
			}
			if (bold[i] && !bold[i + 1]) {
				builder.append("</b>");
			}
		}
		return builder.toString();
	}
}
