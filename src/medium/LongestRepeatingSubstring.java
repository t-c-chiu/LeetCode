package medium;

public class LongestRepeatingSubstring {
	
	public static void main(String[] args) {
		int res = longestRepeatingSubstring("aaaaa");
		System.out.println(res);
	}
	
	public static int longestRepeatingSubstring(String s) {
		int n = s.length(), res = 0;
		TrieNode root = new TrieNode();
		for (int i = 0; i < n; i++) {
			TrieNode cur = root;
			for (int j = i; j < n; j++) {
				int k = s.charAt(j) - 'a';
				if (cur.next[k] == null) {
					cur.next[k] = new TrieNode();
				} else {
					res = Math.max(res, j - i + 1);
				}
				cur = cur.next[k];
			}
		}
		return res;
	}
	
	static class TrieNode {
		TrieNode[] next = new TrieNode[26];
	}
}
