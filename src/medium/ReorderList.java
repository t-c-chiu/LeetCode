package medium;

import util.ListNode;

public class ReorderList {
	
	public static void main(String[] args) {
		ListNode head = ListNode.generateHead(new int[]{1, 2, 3, 4, 5});
		reorderList(head);
		System.out.println(head);
	}
	
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode pre = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode left = head, right = reverse(slow);
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
