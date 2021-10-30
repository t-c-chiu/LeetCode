package medium;

public class ImplementTrieIIPrefixTree {
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");               // Inserts "apple".
		trie.insert("apple");               // Inserts another "apple".
		trie.countWordsEqualTo("apple");    // There are two instances of "apple" so return 2.
		trie.countWordsStartingWith("app"); // "app" is a prefix of "apple" so return 2.
		trie.erase("apple");                // Erases one "apple".
		trie.countWordsEqualTo("apple");    // Now there is only one instance of "apple" so return 1.
		trie.countWordsStartingWith("app"); // return 1
		trie.erase("apple");                // Erases "apple". Now the trie is empty.
		trie.countWordsStartingWith("app"); // return 0
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
				cur.prefix++;
			}
			cur.word++;
		}
		
		public int countWordsEqualTo(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				int j = word.charAt(i) - 'a';
				if (cur.children[j] == null) {
					return 0;
				}
				cur = cur.children[j];
			}
			return cur.word;
		}
		
		public int countWordsStartingWith(String prefix) {
			TrieNode cur = root;
			for (int i = 0; i < prefix.length(); i++) {
				int j = prefix.charAt(i) - 'a';
				if (cur.children[j] == null) {
					return 0;
				}
				cur = cur.children[j];
			}
			return cur.prefix;
		}
		
		public void erase(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				cur = cur.children[word.charAt(i) - 'a'];
				cur.prefix--;
			}
			cur.word--;
		}
		
		class TrieNode {
			TrieNode[] children = new TrieNode[26];
			int prefix;
			int word;
		}
	}
}
