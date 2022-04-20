package medium;

import util.ListNode;

public class InsertionSortList {
	
	public static void main(String[] args) {
		ListNode res = insertionSortList(ListNode.generateHead(new int[]{4, 2, 1, 3}));
		System.out.println(res);
	}
	
	public static ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (head != null) {
			ListNode next = head.next;
			while (pre.next != null && pre.next.val < head.val) {
				pre = pre.next;
			}
			head.next = pre.next;
			pre.next = head;
			head = next;
			pre = dummy;
		}
		return dummy.next;
	}
}
