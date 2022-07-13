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
		List<String> res = new ArrayList<>();
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
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(res, board, i, j, m, n, root);
			}
		}
		return res;
	}
	
	private static void dfs(List<String> res, char[][] board, int i, int j, int m, int n, TrieNode node) {
		char c = board[i][j];
		if (c == '#' || node.next[c - 'a'] == null) {
			return;
		}
		node = node.next[c - 'a'];
		if (node.word != null) {
			res.add(node.word);
			node.word = null;
		}
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		board[i][j] = '#';
		for (int[] dir : dirs) {
			int x = i + dir[0], y = j + dir[1];
			if (x >= 0 && x < m && y >= 0 && y < n) {
				dfs(res, board, x, y, m, n, node);
			}
		}
		board[i][j] = c;
	}
	
	static class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
	
}
