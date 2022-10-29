package hard;

import java.util.HashSet;
import java.util.Set;

public class MaximumDeletionsOnAString {
	
	public static void main(String[] args) {
		int res = deleteString("abcabcdabc");
		System.out.println(res);
	}
	
	public static int deleteString(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(s.charAt(i));
		}
		if (set.size() == 1) {
			return n;
		}
		int[] dp = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			dp[i] = 1;
			for (int j = 1; j <= (n - i) / 2; j++) {
				if (s.substring(i, i + j).equals(s.substring(i + j, i + j + j))) {
					dp[i] = Math.max(dp[i], 1 + dp[i + j]);
				}
			}
		}
		return dp[0];
	}
}
