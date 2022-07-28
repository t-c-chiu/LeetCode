package hard;

import java.util.Stack;
import java.util.TreeMap;

public class MaxStack {
	
	public static void main(String[] args) {
		MaxStack stk = new MaxStack();
		stk.push(5);   // [5] the top of the stack and the maximum number is 5.
		stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
		stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
		stk.top();     // return 5, [5, 1, 5] the stack did not change.
		stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
		stk.top();     // return 1, [5, 1] the stack did not change.
		stk.peekMax(); // return 5, [5, 1] the stack did not change.
		stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
		stk.top();     // return 5, [5] the stack did not change.
	}
	
	Node head;
	Node tail;
	TreeMap<Integer, Stack<Node>> map;
	
	public MaxStack() {
		head = new Node(-1);
		tail = new Node(-1);
		head.next = tail;
		tail.prev = head;
		map = new TreeMap<>();
	}
	
	public void push(int x) {
		Node node = new Node(x);
		insertAfter(node, head);
		map.putIfAbsent(x, new Stack<>());
		map.get(x).push(node);
	}
	
	private void insertAfter(Node node, Node prev) {
		Node next = prev.next;
		prev.next = node;
		node.prev = prev;
		node.next = next;
		next.prev = node;
	}
	
	public int pop() {
		Node node = head.next;
		int val = node.val;
		map.get(val).pop();
		if (map.get(val).isEmpty()) {
			map.remove(val);
		}
		remove(node);
		return val;
	}
	
	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	public int top() {
		return head.next.val;
	}
	
	public int peekMax() {
		return map.lastKey();
	}
	
	public int popMax() {
		Stack<Node> stack = map.lastEntry().getValue();
		Node node = stack.pop();
		if (stack.isEmpty()) {
			map.pollLastEntry();
		}
		remove(node);
		return node.val;
	}
	
	class Node {
		int val;
		Node prev;
		Node next;
		
		Node(int val) {
			this.val = val;
		}
	}
}
