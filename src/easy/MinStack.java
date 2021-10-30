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
	
	Node head;
	
	public MinStack() {
	
	}
	
	public void push(int x) {
		if (head == null) {
			head = new Node(x, x, null);
		} else {
			head = new Node(x, Math.min(x, head.min), head);
		}
	}
	
	public void pop() {
		head = head.next;
	}
	
	public int top() {
		return head.val;
	}
	
	public int getMin() {
		return head.min;
	}
	
	class Node {
		int val;
		int min;
		Node next;
		
		public Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}
}
