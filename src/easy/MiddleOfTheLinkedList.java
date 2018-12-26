package easy;

import util.ListNode;

public class MiddleOfTheLinkedList {
	public static void main(String[] args) {
		MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode result = middleOfTheLinkedList.middleNode(head);
		head.next.next.next = new ListNode(4);
		result = middleOfTheLinkedList.middleNode(head);
		head.next.next.next.next = new ListNode(5);
		result = middleOfTheLinkedList.middleNode(head);
	}

	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
