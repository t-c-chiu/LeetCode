package easy;

import util.ListNode;

public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode result = reverseList(ListNode.generateHead(new int[]{1, 2, 3, 4, 5}));
		System.out.println(result);
	}
	
	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode prev = null, cur = head, next;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}


