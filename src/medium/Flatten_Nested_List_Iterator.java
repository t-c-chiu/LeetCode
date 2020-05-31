package medium;

import util.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flatten_Nested_List_Iterator {
	
	public class NestedIterator implements Iterator<Integer> {
		
		private Iterator<Integer> it;
		
		public NestedIterator(List<NestedInteger> nestedList) {
			List<Integer> list = new ArrayList<>();
			addIntegers(list, nestedList);
			it = list.iterator();
		}
		
		private void addIntegers(List<Integer> list, List<NestedInteger> nestedList) {
			for (NestedInteger nestedInteger : nestedList) {
				if (nestedInteger.isInteger()) {
					list.add(nestedInteger.getInteger());
				} else {
					addIntegers(list, nestedInteger.getList());
				}
			}
		}
		
		@Override
		public Integer next() {
			return it.next();
		}
		
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}
	}
}
