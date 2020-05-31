package medium;

import java.util.HashMap;
import java.util.Map;

public class Copy_List_with_Random_Pointer {
	
	public static void main(String[] args) {
	
	}
	
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		
		Map<Node, Node> map = new HashMap<>();
		Node node = head;
		while (node != null) {
			map.put(node, new Node(node.val));
			node = node.next;
		}
		
		node = head;
		while (node != null) {
			Node newNode = map.get(node);
			newNode.next = map.get(node.next);
			newNode.random = map.get(node.random);
			node = node.next;
		}
		
		return map.get(head);
	}
	
	class Node {
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
