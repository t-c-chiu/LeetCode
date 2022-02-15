package medium;

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
		int i = 0, j = 0;
		while (i < s.length() && j < word.length()) {
			if (s.charAt(i) != word.charAt(j)) {
				return false;
			}
			int len1 = getRepeatedChars(s, i);
			int len2 = getRepeatedChars(word, j);
			if (len1 < len2 || len1 < 3 && len1 != len2) {
				return false;
			}
			i += len1;
			j += len2;
		}
		return i == s.length() && j == word.length();
	}
	
	private static int getRepeatedChars(String s, int i) {
		int count = 1;
		while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
			i++;
			count++;
		}
		return count;
	}
}
