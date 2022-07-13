package medium;

import util.ListNode;

public class RemoveNthNodeFromEndOfList {
	
	public static void main(String[] args) {
		ListNode res = removeNthFromEnd(ListNode.generateHead(new int[]{1, 2}), 1);
		System.out.println(res);
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0), slow = dummy, fast = dummy;
		dummy.next = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
