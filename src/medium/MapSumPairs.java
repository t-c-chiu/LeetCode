package medium;

public class MapSumPairs {
	
	public static void main(String[] args) {
		MapSum mapSum = new MapSum();
		mapSum.insert("apple", 3);
		int res = mapSum.sum("ap");
		System.out.println(res);
		mapSum.insert("app", 2);
		res = mapSum.sum("ap");
		System.out.println(res);
	}
	
	static class MapSum {
		
		TrieNode root;
		
		/**
		 * Initialize your data structure here.
		 */
		public MapSum() {
			root = new TrieNode(0);
		}
		
		public void insert(String key, int val) {
			TrieNode cur = root;
			for (int i = 0; i < key.length(); i++) {
				int j = key.charAt(i) - 'a';
				if (cur.next[j] == null) {
					cur.next[j] = new TrieNode(0);
				}
				cur = cur.next[j];
			}
			cur.val = val;
		}
		
		public int sum(String prefix) {
			TrieNode cur = root;
			for (int i = 0; i < prefix.length(); i++) {
				int j = prefix.charAt(i) - 'a';
				if (cur.next[j] == null) {
					return 0;
				}
				cur = cur.next[j];
			}
			
			return sum(cur);
		}
		
		private int sum(TrieNode trieNode) {
			if (trieNode == null) {
				return 0;
			}
			
			int sum = trieNode.val;
			for (TrieNode child : trieNode.next) {
				if (child != null) {
					sum += sum(child);
				}
			}
			return sum;
		}
		
		class TrieNode {
			int val;
			TrieNode[] next;
			
			TrieNode(int val) {
				this.val = val;
				next = new TrieNode[26];
			}
		}
	}
}
