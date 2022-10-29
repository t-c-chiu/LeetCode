package hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	
	public static void main(String[] args) {
		List<String> res = findWords(new char[][]{
						{'a', 'b', 'c'},
						{'a', 'e', 'd'},
						{'a', 'f', 'g'}},
				new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"});
		System.out.println(res);
	}
	
	public static List<String> findWords(char[][] board, String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				int j = word.charAt(i) - 'a';
				if (cur.next[j] == null) {
					cur.next[j] = new TrieNode();
				}
				cur = cur.next[j];
			}
			cur.word = word;
		}
		List<String> res = new ArrayList<>();
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(res, root, board, i, j, m, n);
			}
		}
		return res;
	}
	
	private static void dfs(List<String> res, TrieNode cur, char[][] board, int i, int j, int m, int n) {
		if (i < 0 || i == m || j < 0 || j == n || board[i][j] == '*' || cur.next[board[i][j] - 'a'] == null) {
			return;
		}
		char c = board[i][j];
		board[i][j] = '*';
		TrieNode next = cur.next[c - 'a'];
		if (next.word != null) {
			res.add(next.word);
			next.word = null;
		}
		dfs(res, next, board, i + 1, j, m, n);
		dfs(res, next, board, i - 1, j, m, n);
		dfs(res, next, board, i, j + 1, m, n);
		dfs(res, next, board, i, j - 1, m, n);
		board[i][j] = c;
	}
	
	static class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
}
