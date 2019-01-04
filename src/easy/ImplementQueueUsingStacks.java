package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ImplementQueueUsingStacks {
	public static void main(String[] args) {
		MyQueue queue = new ImplementQueueUsingStacks().new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.peek());
		System.out.println(queue.pop());
		System.out.println(queue.empty());
	}

	class MyQueue {
		private Stack<Integer> stack;

		/**
		 * Initialize your data structure here.
		 */
		public MyQueue() {
			stack = new Stack<>();
		}

		/**
		 * Push element x to the back of queue.
		 */
		public void push(int x) {
			List<Integer> list = new ArrayList<>();
			while (!stack.isEmpty()) {
				list.add(stack.pop());
			}
			stack.push(x);
			for (int i = list.size() - 1; i >= 0; i--)
				stack.push(list.get(i));
		}

		/**
		 * Removes the element from in front of queue and returns that element.
		 */
		public int pop() {
			return stack.pop();
		}

		/**
		 * Get the front element.
		 */
		public int peek() {
			return stack.peek();
		}

		/**
		 * Returns whether the queue is empty.
		 */
		public boolean empty() {
			return stack.isEmpty();
		}
	}
}
