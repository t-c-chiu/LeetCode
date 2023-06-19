package hard;

import java.util.*;

public class ConcatenatedWords {
	
	public static void main(String[] args) {
		List<String> res = findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"});
		System.out.println(res);
	}
	
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String::length));
		List<String> res = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (String word : words) {
			if (isConcatenated(word, set)) {
				res.add(word);
			}
			set.add(word);
		}
		return res;
	}
	
	private static boolean isConcatenated(String word, Set<String> set) {
		int n = word.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int r = 1; r <= n; r++) {
			for (int l = 0; l < r; l++) {
				if (dp[l] && set.contains(word.substring(l, r))) {
					dp[r] = true;
					break;
				}
			}
		}
		return dp[n];
	}
}
