package medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	
	public static void main(String[] args) {
		Node head = new Node(3);
		head.next = new Node(3);
		head.next.random = head;
		head.next.next = new Node(3);
		Node res = copyRandomList(head);
		System.out.println(res);
	}
	
	public static Node copyRandomList(Node head) {
		Map<Node, Node> memo = new HashMap<>();
		return copyRandomList(head, memo);
	}
	
	private static Node copyRandomList(Node node, Map<Node, Node> memo) {
		if (node == null) {
			return null;
		}
		if (memo.containsKey(node)) {
			return memo.get(node);
		}
		Node newNode = new Node(node.val);
		memo.put(node, newNode);
		newNode.next = copyRandomList(node.next, memo);
		newNode.random = copyRandomList(node.random, memo);
		return newNode;
	}
	
	static class Node {
		int val;
		Node next;
		Node random;
		
		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
		
	}
}
