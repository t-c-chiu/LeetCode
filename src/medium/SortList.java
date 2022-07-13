package medium;

import util.ListNode;

public class SortList {
	
	public static void main(String[] args) {
		ListNode res = sortList(ListNode.generateHead(new int[]{-1, 5, 3, 4, 0}));
		System.out.println(res);
	}
	
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		return merge(left, right);
	}
	
	private static ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0), cur = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				cur.next = left;
				left = left.next;
			} else {
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
		if (left != null) {
			cur.next = left;
		}
		if (right != null) {
			cur.next = right;
		}
		return dummy.next;
	}
}
