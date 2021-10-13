package medium;

public class ImplementTrie {
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("ab"));
		System.out.println(trie.startsWith("ab"));
		trie.insert("acd");
		System.out.println(trie.search("acd"));
	}
	
	static class Trie {
		
		TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				int j = word.charAt(i) - 'a';
				if (cur.children[j] == null) {
					cur.children[j] = new TrieNode();
				}
				cur = cur.children[j];
			}
			cur.isWord = true;
		}
		
		public boolean search(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				int j = word.charAt(i) - 'a';
				if (cur.children[j] == null) {
					return false;
				}
				cur = cur.children[j];
			}
			return cur.isWord;
		}
		
		public boolean startsWith(String prefix) {
			TrieNode cur = root;
			for (int i = 0; i < prefix.length(); i++) {
				int j = prefix.charAt(i) - 'a';
				if (cur.children[j] == null) {
					return false;
				}
				cur = cur.children[j];
			}
			return true;
		}
		
		class TrieNode {
			boolean isWord;
			TrieNode[] children = new TrieNode[26];
		}
	}
	
}
