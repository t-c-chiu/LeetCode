package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordWithAllPrefixes {
	
	public static void main(String[] args) {
		String res = longestWord(new String[]{"abc", "bc", "ab", "qwe"});
		System.out.println(res);
	}
	
	public static String longestWord(String[] words) {
		Arrays.sort(words, (o1, o2) -> {
			int len1 = o1.length();
			int len2 = o2.length();
			if (len1 == len2) {
				return o2.compareTo(o1);
			}
			return len1 - len2;
		});
		
		Set<String> set = new HashSet<>();
		set.add("");
		String res = "";
		for (String word : words) {
			String prev = word.substring(0, word.length() - 1);
			if (set.contains(prev)) {
				set.add(word);
				res = word;
			}
		}
		return res;
	}
}
