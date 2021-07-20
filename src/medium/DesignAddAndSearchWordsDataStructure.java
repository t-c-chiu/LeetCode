package medium;

public class DesignAddAndSearchWordsDataStructure {
	
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		wordDictionary.search("pad"); // return False
		wordDictionary.search("bad"); // return True
		wordDictionary.search(".ad"); // return True
		wordDictionary.search("b.."); // return True
	}
	
	static class WordDictionary {
		TrieNode root = new TrieNode();
		
		public void addWord(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (node.children[idx] == null) {
					node.children[idx] = new TrieNode();
				}
				node = node.children[idx];
			}
			node.isWord = true;
		}
		
		public boolean search(String word) {
			return search(word, root, 0);
		}
		
		private boolean search(String word, TrieNode node, int index) {
			if (index == word.length()) {
				return node.isWord;
			}
			if (word.charAt(index) != '.') {
				int idx = word.charAt(index) - 'a';
				return node.children[idx] != null
						&& search(word, node.children[idx], index + 1);
			} else {
				for (TrieNode child : node.children) {
					if (child != null) {
						if (search(word, child, index + 1)) {
							return true;
						}
					}
				}
			}
			return false;
		}
	}
	
	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isWord = false;
	}

//	static class WordDictionary {
//
//		Map<Integer, Set<String>> map;
//
//		public WordDictionary() {
//			map = new HashMap<>();
//		}
//
//		public void addWord(String word) {
//			int length = word.length();
//			map.putIfAbsent(length, new HashSet<>());
//			map.get(length).add(word);
//		}
//
//		public boolean search(String word) {
//			int length = word.length();
//			if (!map.containsKey(length)) {
//				return false;
//			}
//
//			Set<String> set = map.get(length);
//			if (set.contains(word)) {
//				return true;
//			} else if (!word.contains(".")) {
//				return false;
//			}
//
//			for (String s : set) {
//				if (isSame(s, word)) {
//					return true;
//				}
//			}
//			return false;
//		}
//
//		private boolean isSame(String s, String word) {
//			for (int i = 0; i < s.length(); i++) {
//				if (word.charAt(i) != '.' && s.charAt(i) != word.charAt(i)) {
//					return false;
//				}
//			}
//			return true;
//		}
//	}
}
