package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	public static void main(String[] args) {
		boolean res = wordBreak("applepenapple", Arrays.asList("apple", "pen"));
		System.out.println(res);
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(s.substring(j, i))) {
					dp[i] = true;
				}
			}
		}
		return dp[n];
	}
}
