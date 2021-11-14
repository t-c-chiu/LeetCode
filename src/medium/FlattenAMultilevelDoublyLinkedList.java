package medium;

public class FlattenAMultilevelDoublyLinkedList {
	
	public static void main(String[] args) {
	}
	
	public static Node flatten(Node head) {
		Node cur = head;
		while (cur != null) {
			if (cur.child != null) {
				Node next = cur.next;
				cur.next = flatten(cur.child);
				cur.next.prev = cur;
				cur.child = null;
				
				while (cur.next != null) {
					cur = cur.next;
				}
				
				if (next != null) {
					cur.next = next;
					next.prev = cur;
				}
			}
			cur = cur.next;
		}
		return head;
	}
	
	static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	}
}
