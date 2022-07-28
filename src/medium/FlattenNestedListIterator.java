package medium;

import java.util.*;

public class FlattenNestedListIterator {
	
	public static void main(String[] args) {
	
	}
	
	public class NestedIterator implements Iterator<Integer> {
		
		Deque<NestedInteger> deque = new ArrayDeque<>();
		
		public NestedIterator(List<NestedInteger> nestedList) {
			addList(nestedList);
		}
		
		private void addList(List<NestedInteger> list) {
			for (int i = list.size() - 1; i >= 0; i--) {
				deque.offerFirst(list.get(i));
			}
		}
		
		@Override
		public Integer next() {
			if (!hasNext()) {
				return null;
			}
			return deque.pollFirst().getInteger();
		}
		
		@Override
		public boolean hasNext() {
			while (!deque.isEmpty() && !deque.peekFirst().isInteger()) {
				addList(deque.pollFirst().getList());
			}
			return !deque.isEmpty();
		}
	}

//	public class NestedIterator implements Iterator<Integer> {
//
//		Iterator<Integer> it;
//
//		public NestedIterator(List<NestedInteger> nestedList) {
//			List<Integer> list = new ArrayList<>();
//			add(list, nestedList);
//			it = list.iterator();
//		}
//
//		private void add(List<Integer> list, List<NestedInteger> nestedList) {
//			for (NestedInteger nestedInteger : nestedList) {
//				if (nestedInteger.isInteger()) {
//					list.add(nestedInteger.getInteger());
//				} else {
//					add(list, nestedInteger.getList());
//				}
//			}
//		}
//
//		@Override
//		public Integer next() {
//			return it.next();
//		}
//
//		@Override
//		public boolean hasNext() {
//			return it.hasNext();
//		}
//	}
	
	public interface NestedInteger {
		
		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();
		
		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();
		
		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return empty list if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
}
