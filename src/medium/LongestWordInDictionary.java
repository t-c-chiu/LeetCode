package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
	
	public static void main(String[] args) {
		String res = longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
		System.out.println(res);
	}
	
	public static String longestWord(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String::length));
		Set<String> set = new HashSet<>();
		set.add("");
		String res = "";
		for (String word : words) {
			if (set.contains(word.substring(0, word.length() - 1))) {
				set.add(word);
				if (word.length() > res.length() || word.compareTo(res) < 0) {
					res = word;
				}
			}
		}
		return res;
	}
	
}
