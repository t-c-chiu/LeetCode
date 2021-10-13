package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DesignFrontMiddleBackQueue {
	
	public static void main(String[] args) {
		FrontMiddleBackQueue q = new FrontMiddleBackQueue();
		q.pushFront(1);   // [1]
		q.pushBack(2);    // [1, 2]
		q.pushMiddle(3);  // [1, 3, 2]
		q.pushMiddle(4);  // [1, 4, 3, 2]
		q.popFront();     // return 1 -> [4, 3, 2]
		q.popMiddle();    // return 3 -> [4, 2]
		q.popMiddle();    // return 4 -> [2]
		q.popBack();      // return 2 -> []
		q.popFront();     // return -1 -> [] (The queue is empty)
	}
	
	static class FrontMiddleBackQueue {
		
		Deque<Integer> front;
		Deque<Integer> back;
		
		public FrontMiddleBackQueue() {
			front = new ArrayDeque<>();
			back = new ArrayDeque<>();
		}
		
		public void pushFront(int val) {
			front.offerFirst(val);
			adjust();
		}
		
		public void pushMiddle(int val) {
			front.offerLast(val);
			adjust();
		}
		
		public void pushBack(int val) {
			back.offerLast(val);
			adjust();
		}
		
		public int popFront() {
			if (front.isEmpty()) {
				return back.isEmpty() ? -1 : back.pollFirst();
			}
			int val = front.pollFirst();
			adjust();
			return val;
		}
		
		public int popMiddle() {
			if (back.isEmpty()) {
				return -1;
			}
			int val = front.size() == back.size() ? front.pollLast() : back.pollFirst();
			adjust();
			return val;
		}
		
		public int popBack() {
			int val = back.isEmpty() ? -1 : back.pollLast();
			adjust();
			return val;
		}
		
		private void adjust() {
			if (front.size() > back.size()) {
				back.offerFirst(front.pollLast());
			} else if (front.size() < back.size() - 1) {
				front.offerLast(back.pollFirst());
			}
		}
	}
}
