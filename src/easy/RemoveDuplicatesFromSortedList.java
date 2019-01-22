package easy;

import util.ListNode;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
	}

	// 1 -> 1 -> 2 -> 3 -> 3
	// 1 -> 2 -> 3
	public ListNode deleteDuplicates(ListNode head) {
		ListNode newHead = head;
		while (head != null) {
			ListNode next = head.next;
			if (next != null && head.val == next.val)
				head.next = next.next;
			else
				head = head.next;
		}
		return newHead;
	}
}
