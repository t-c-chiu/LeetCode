package medium;

import java.util.Arrays;
import java.util.List;

public class Word_Break {
	
	public static void main(String[] args) {
		Word_Break test = new Word_Break();
		boolean res = test.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
		System.out.println(res);
	}
	
	// dp[i] = whether s(0, i) can be segmented
	public boolean wordBreak(String s, List<String> wordDict) {
		int length = s.length();
		boolean[] dp = new boolean[length + 1];
		dp[0] = true;
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
				}
			}
		}
		return dp[length];
	}
}
