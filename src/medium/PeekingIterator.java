package medium;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
	
	Integer next;
	Iterator<Integer> iterator;
	
	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
		if (iterator.hasNext()) {
			next = iterator.next();
		}
	}
	
	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer res = next;
		next = iterator.hasNext() ? iterator.next() : null;
		return res;
	}
	
	@Override
	public boolean hasNext() {
		return next != null;
	}
}