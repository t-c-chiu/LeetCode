package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IteratorForCombination {
	
	public static void main(String[] args) {
		CombinationIterator itr = new CombinationIterator("abcde", 3);
		itr.next();    // return "ab"
		itr.hasNext(); // return True
		itr.next();    // return "ac"
		itr.hasNext(); // return True
		itr.next();    // return "bc"
		itr.hasNext(); // return False
	}
	
	static class CombinationIterator {
		
		private Queue<String> queue;
		
		public CombinationIterator(String characters, int combinationLength) {
			queue = new LinkedList<>();
			buildCombination(characters, combinationLength, "", 0);
		}
		
		private void buildCombination(String str, int combinationLength, String temp, int start) {
			if (temp.length() == combinationLength) {
				queue.offer(temp);
				return;
			}
			for (int i = start; i < str.length(); i++) {
				buildCombination(str, combinationLength, temp + str.charAt(i), i + 1);
			}
		}
		
		public String next() {
			return queue.poll();
		}
		
		public boolean hasNext() {
			return !queue.isEmpty();
		}
	}
	
	/**
	 * abcde 3
	 * abc abd abe acd ace ade bcd bce bde cde
	 */
//	static class CombinationIterator {
//
//		String cur;
//		String characters;
//		Map<Character, Integer> map;
//		boolean hasNext;
//
//		public CombinationIterator(String characters, int combinationLength) {
//			map = new HashMap<>();
//			for (int i = 0; i < characters.length(); i++) {
//				map.put(characters.charAt(i), i);
//			}
//			this.cur = characters.substring(0, combinationLength);
//			this.characters = characters;
//			hasNext = true;
//		}
//
//		public String next() {
//			String res = cur;
//			StringBuilder builder = new StringBuilder();
//			for (int i = cur.length() - 1, j = characters.length() - 1; i >= 0 && j >= 0; i--, j--) {
//				char c = cur.charAt(i);
//				if (c != characters.charAt(j)) {
//					int k = map.get(c) + 1;
//					cur = builder.append(cur, 0, i).append(characters, k, k + res.length() - builder.length()).toString();
//					return res;
//				}
//			}
//			hasNext = false;
//			return res;
//		}
//
//		public boolean hasNext() {
//			return hasNext;
//		}
//	}
}
