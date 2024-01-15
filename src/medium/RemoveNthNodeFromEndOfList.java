package medium;

import util.ListNode;

class RemoveNthNodeFromEndOfList {
	
	public static void main(String[] args) {
		ListNode res = removeNthFromEnd(ListNode.generateHead(new int[]{1, 2, 3, 4, 5}), 2);
		System.out.println(res);
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0), prev = dummy, fast = head, slow = head;
		dummy.next = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		prev.next = slow.next;
		return dummy.next;
	}
}
