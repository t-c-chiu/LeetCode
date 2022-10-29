package medium;

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
		head = new Node(-1, -1);
	}
	
	public void push(int val) {
		Node node = new Node(val, head.next == null ? val : Math.min(val, head.next.min));
		node.next = head.next;
		head.next = node;
	}
	
	public void pop() {
		head.next = head.next.next;
	}
	
	public int top() {
		return head.next.val;
	}
	
	public int getMin() {
		return head.next.min;
	}
	
	class Node {
		int val;
		int min;
		Node next;
		
		Node(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}
}
