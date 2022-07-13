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
		
		TrieNode head;
		
		public Trie() {
			head = new TrieNode();
		}
		
		public void insert(String word) {
			TrieNode cur = head;
			for (int i = 0; i < word.length(); i++) {
				int j = word.charAt(i) - 'a';
				if (cur.next[j] == null) {
					cur.next[j] = new TrieNode();
				}
				cur = cur.next[j];
			}
			cur.isWord = true;
		}
		
		public boolean search(String word) {
			TrieNode cur = head;
			for (int i = 0; i < word.length(); i++) {
				int j = word.charAt(i) - 'a';
				if (cur.next[j] == null) {
					return false;
				}
				cur = cur.next[j];
			}
			return cur.isWord;
		}
		
		public boolean startsWith(String prefix) {
			TrieNode cur = head;
			for (int i = 0; i < prefix.length(); i++) {
				int j = prefix.charAt(i) - 'a';
				if (cur.next[j] == null) {
					return false;
				}
				cur = cur.next[j];
			}
			return true;
		}
		
		class TrieNode {
			
			TrieNode[] next = new TrieNode[26];
			boolean isWord;
		}
	}
}
