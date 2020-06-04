package medium;

import java.util.*;

public class Iterator_for_Combination {
	
	public static void main(String[] args) {
		CombinationIterator test = new Iterator_for_Combination().new CombinationIterator("abc", 2);
		System.out.println(test.next());
	}
	
	class CombinationIterator {
		
		private Queue<String> queue;
		
		public CombinationIterator(String characters, int combinationLength) {
			queue = new LinkedList<>();
			buildCombination(characters, combinationLength, "", 0);
		}
		
		private void buildCombination(String str, int combinationLength, String temp, int start) {
			if (temp.length() == combinationLength) {
				queue.add(temp);
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
}
