package easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.peek());
		System.out.println(queue.pop());
		System.out.println(queue.empty());
	}
	
	static class MyQueue {
		
		Stack<Integer> input;
		Stack<Integer> output;
		
		public MyQueue() {
			input = new Stack<>();
			output = new Stack<>();
		}
		
		public void push(int x) {
			input.push(x);
		}
		
		public int pop() {
			fillOutput();
			return output.pop();
		}
		
		private void fillOutput() {
			if (output.isEmpty()) {
				while (!input.isEmpty()) {
					output.push(input.pop());
				}
			}
		}
		
		public int peek() {
			fillOutput();
			return output.peek();
		}
		
		public boolean empty() {
			return input.isEmpty() && output.isEmpty();
		}
	}
	
}
