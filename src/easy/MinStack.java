package easy;

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

	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;

	public MinStack() {
		dataStack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		dataStack.push(x);
		if (minStack.isEmpty()) {
			minStack.push(x);
		} else {
			minStack.push(Math.min(x, minStack.peek()));
		}
	}

	public void pop() {
		dataStack.pop();
		minStack.pop();
	}

	public int top() {
		return dataStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
