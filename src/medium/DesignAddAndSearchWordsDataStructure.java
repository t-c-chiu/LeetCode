package medium;

public class DesignAddAndSearchWordsDataStructure {
	
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		boolean res = wordDictionary.search("pad"); // return False
		System.out.println(res);
		res = wordDictionary.search("bad"); // return True
		System.out.println(res);
		res = wordDictionary.search(".ad"); // return True
		System.out.println(res);
		res = wordDictionary.search("b.."); // return True
		System.out.println(res);
	}
	
	static class WordDictionary {
		
		TrieNode root;
		
		public WordDictionary() {
			root = new TrieNode();
		}
		
		public void addWord(String word) {
			TrieNode cur = root;
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
			return search(root, word, 0);
		}
		
		private boolean search(TrieNode root, String word, int i) {
			if (i == word.length()) {
				return root.isWord;
			}
			char c = word.charAt(i);
			if (c == '.') {
				for (TrieNode next : root.next) {
					if (next != null) {
						if (search(next, word, i + 1)) {
							return true;
						}
					}
				}
			} else {
				int j = c - 'a';
				return root.next[j] != null && search(root.next[j], word, i + 1);
			}
			return false;
		}
		
		class TrieNode {
			TrieNode[] next = new TrieNode[26];
			boolean isWord;
		}
	}
}
