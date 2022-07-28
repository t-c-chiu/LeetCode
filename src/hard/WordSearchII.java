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
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, res, root);
			}
		}
		return res;
	}
	
	private static void dfs(char[][] board, int i, int j, List<String> res, TrieNode node) {
		if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == '#' || node.next[board[i][j] - 'a'] == null) {
			return;
		}
		char c = board[i][j];
		node = node.next[c - 'a'];
		if (node.word != null) {
			res.add(node.word);
			node.word = null;
		}
		board[i][j] = '#';
		dfs(board, i + 1, j, res, node);
		dfs(board, i - 1, j, res, node);
		dfs(board, i, j + 1, res, node);
		dfs(board, i, j - 1, res, node);
		board[i][j] = c;
	}
	
	static class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
}
