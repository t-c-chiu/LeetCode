package medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	
	public static void main(String[] args) {
		Node head = new Node(3);
		head.next = new Node(3);
		head.next.random = head;
		head.next.next = new Node(3);
		copyRandomList(head);
	}
	
	static public Node copyRandomList(Node head) {
		return copyRandomList(head, new HashMap<>());
	}
	
	private static Node copyRandomList(Node node, Map<Node, Node> map) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node)) {
			return map.get(node);
		}
		Node newNode = new Node(node.val);
		map.put(node, newNode);
		newNode.next = copyRandomList(node.next, map);
		newNode.random = copyRandomList(node.random, map);
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
