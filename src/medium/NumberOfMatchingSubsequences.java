package medium;

import java.util.*;

public class NumberOfMatchingSubsequences {
	
	public static void main(String[] args) {
		int res = numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
		System.out.println(res);
	}
	
	public static int numMatchingSubseq(String s, String[] words) {
		int res = 0;
		Map<Character, List<String>> map = new HashMap<>();
		for (String word : words) {
			char start = word.charAt(0);
			map.putIfAbsent(start, new ArrayList<>());
			map.get(start).add(word);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			List<String> list = map.remove(c);
			if (list != null) {
				for (String word : list) {
					if (word.length() == 1) {
						res++;
					} else {
						word = word.substring(1);
						char start = word.charAt(0);
						map.putIfAbsent(start, new ArrayList<>());
						map.get(start).add(word);
					}
				}
			}
		}
		return res;
	}
}
