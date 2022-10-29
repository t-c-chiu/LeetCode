package hard;

import java.util.Arrays;

public class SumOfPrefixScoresOfStrings {
	
	public static void main(String[] args) {
		int[] res = sumPrefixScores(new String[]{"abc", "ab", "bc", "b"});
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] sumPrefixScores(String[] words) {
		int n = words.length;
		int[] res = new int[n];
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				int j = word.charAt(i) - 'a';
				if (cur.next[j] == null) {
					cur.next[j] = new TrieNode();
				}
				cur = cur.next[j];
				cur.count++;
			}
		}
		for (int i = 0; i < words.length; i++) {
			TrieNode cur = root;
			int count = 0;
			String word = words[i];
			for (int j = 0; j < word.length(); j++) {
				int k = word.charAt(j) - 'a';
				cur = cur.next[k];
				count += cur.count;
			}
			res[i] = count;
		}
		return res;
	}
	
	static class TrieNode {
		TrieNode[] next = new TrieNode[26];
		int count;
	}
}
