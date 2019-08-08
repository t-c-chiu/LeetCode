package medium;

public class NumberOfMatchingSubsequences {
	public static void main(String[] args) {
		System.out.println(new NumberOfMatchingSubsequences().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
	}
	
	/**
	 * Example :
	 * Input:
	 * S = "abcde"
	 * words = ["a", "bb", "acd", "ace"]
	 * Output: 3
	 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
	 */
	public int numMatchingSubseq(String S, String[] words) {
		int ans = 0;
		out:
		for (String word : words) {
			int prev = -1, current;
			for (char c : word.toCharArray()) {
				current = S.indexOf(c, prev + 1);
				if (current == -1 || current <= prev)
					continue out;
				prev = current;
			}
			ans++;
		}
		return ans;
	}
}
