package medium;

public class InsertIntoASortedCircularLinkedList {
	
	public static void main(String[] args) {
	}
	
	public static Node insert(Node head, int insertVal) {
		Node newNode = new Node(insertVal);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}
		Node cur = head;
		while (true) {
			Node next = cur.next;
			if (cur.val <= next.val && cur.val <= insertVal && insertVal <= next.val
					|| cur.val > next.val && (cur.val <= insertVal || insertVal <= next.val)
					|| next == head) {
				newNode.next = cur.next;
				cur.next = newNode;
				break;
			}
			cur = cur.next;
		}
		return head;
	}
	
	static class Node {
		public int val;
		public Node next;
		
		public Node() {
		}
		
		public Node(int _val) {
			val = _val;
		}
		
		public Node(int _val, Node _next) {
			val = _val;
			next = _next;
		}
	}
}
