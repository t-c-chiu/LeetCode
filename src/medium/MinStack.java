package medium;

import java.util.Stack;

public class MinStack {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
	
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();
	
	public void push(int val) {
		stack.push(val);
		if (minStack.isEmpty() || val < minStack.peek()) {
			minStack.push(val);
		} else {
			minStack.push(minStack.peek());
		}
	}
	
	public void pop() {
		stack.pop();
		minStack.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}
	
}
