package medium;

import util.ListNode;

public class ReorderList {
	
	public static void main(String[] args) {
		ListNode head = ListNode.generateHead(new int[]{1, 2, 3, 4, 5, 6});
		reorderList(head);
		System.out.println(head);
	}
	
	public static void reorderList(ListNode head) {
		ListNode prev = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (prev == null) {
			return;
		}
		prev.next = null;
		slow = reverse(slow);
		ListNode left = head, right = slow;
		while (left != null) {
			ListNode leftNext = left.next;
			ListNode rightNext = right.next;
			left.next = right;
			if (leftNext != null) {
				right.next = leftNext;
			}
			left = leftNext;
			right = rightNext;
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
