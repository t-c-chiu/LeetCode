package medium;

public class ExpressiveWords {
	
	public static void main(String[] args) {
		int res = expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
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
		int i = 0, j = 0, m = s.length(), n = word.length();
		while (i < m && j < n) {
			if (s.charAt(i) == word.charAt(j)) {
				int a = getRepeatedChar(s, i);
				int b = getRepeatedChar(word, j);
				if (a < b || a != b && a < 3) {
					return false;
				}
				i += a;
				j += b;
			} else {
				return false;
			}
		}
		return i == m && j == n;
	}
	
	private static int getRepeatedChar(String s, int i) {
		int count = 0;
		char c = s.charAt(i);
		while (i < s.length() && s.charAt(i) == c) {
			count++;
			i++;
		}
		return count;
	}
	
}
