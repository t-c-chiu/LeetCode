package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ExpressiveWords {
	
	public static void main(String[] args) {
		int res = expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"});
		System.out.println(res);
	}
	
	public static int expressiveWords(String s, String[] words) {
		int res = 0;
		for (String word : words) {
			if (isStretchy(s, word)) {
				res++;
			}
		}
		return res;
	}
	
	private static boolean isStretchy(String s, String word) {
		int i = 0;
		int j = 0;
		while (i < s.length() && j < word.length()) {
			if (s.charAt(i) != word.charAt(j)) {
				return false;
			}
			int c1 = getRepeatedChars(i, s);
			int c2 = getRepeatedChars(j, word);
			if (c1 < 3 && c1 != c2 || c2 >= 3 && c1 < c2) {
				return false;
			}
			i += c1;
			j += c2;
		}
		return i == s.length() && j == word.length();
	}
	
	private static int getRepeatedChars(int start, String s) {
		for (int i = start + 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(start)) {
				return i - start;
			}
		}
		return s.length() - start;
	}
}
