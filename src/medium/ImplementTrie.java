package medium;

public class ImplementTrie {
	
	public static void main(String[] args) {
		Trie trie = new ImplementTrie().new Trie();
		trie.insert("abc");
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("ab"));
		System.out.println(trie.startsWith("ab"));
		trie.insert("acd");
		System.out.println(trie.search("acd"));
	}
	
	class Trie {
		private boolean isWord;
		private Trie[] next;
		
		public Trie() {
			next = new Trie[26];
		}
		
		public void insert(String word) {
			Trie trie = this;
			for (char c : word.toCharArray()) {
				int i = c - 'a';
				Trie nextTrie = trie.next[i];
				if (nextTrie == null) {
					nextTrie = new Trie();
					trie.next[i] = nextTrie;
				}
				trie = nextTrie;
			}
			trie.isWord = true;
		}
		
		public boolean search(String word) {
			Trie trie = this;
			for (char c : word.toCharArray()) {
				Trie nextTrie = trie.next[c - 'a'];
				if (nextTrie == null)
					return false;
				trie = nextTrie;
			}
			return trie.isWord;
		}
		
		public boolean startsWith(String prefix) {
			Trie trie = this;
			for (char c : prefix.toCharArray()) {
				Trie nextTrie = trie.next[c - 'a'];
				if (nextTrie == null)
					return false;
				trie = nextTrie;
			}
			return true;
		}
	}
}
