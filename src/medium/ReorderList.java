package medium;

import util.ListNode;

public class ReorderList {
	
	public static void main(String[] args) {
		ListNode head = ListNode.generateHead(new int[]{1, 2, 3, 4, 5});
		reorderList(head);
		System.out.println(head);
	}
	
	public static void reorderList(ListNode head) {
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (prev == null) {
			return;
		}
		prev.next = null;
		ListNode rightHead = reverse(slow);
		merge(head, rightHead);
	}
	
	private static void merge(ListNode l1, ListNode l2) {
		while (l1 != null) {
			ListNode n1 = l1.next;
			ListNode n2 = l2.next;
			l1.next = l2;
			if (n1 != null) {
				l2.next = n1;
			}
			l1 = n1;
			l2 = n2;
		}
	}
	
	private static ListNode reverse(ListNode node) {
		ListNode prev = null, cur = node, next;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}
