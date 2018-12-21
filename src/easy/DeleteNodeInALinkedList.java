package easy;

import util.ListNode;

public class DeleteNodeInALinkedList {
	public static void main(String[] args) {

	}

	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}
}
