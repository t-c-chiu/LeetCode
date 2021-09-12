package medium;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
	
	public static void main(String[] args) {
		String res = findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"));
		System.out.println(res);
	}
	
	public static String findLongestWord(String s, List<String> dictionary) {
		String res = "";
		for (String word : dictionary) {
			if (isSubsequence(word, s) &&
					(word.length() > res.length() || word.length() == res.length() && word.compareTo(res) < 0)) {
				res = word;
			}
		}
		return res;
	}
	
	private static boolean isSubsequence(String word, String s) {
		int i = 0;
		int j = 0;
		while (i < word.length() && j < s.length()) {
			if (word.charAt(i) == s.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == word.length();
	}
}
