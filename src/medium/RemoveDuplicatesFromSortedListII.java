package medium;

import util.ListNode;

public class RemoveDuplicatesFromSortedListII {
	
	public static void main(String[] args) {
		ListNode res = deleteDuplicates(ListNode.generateHead(new int[]{1, 2, 3, 3, 4, 4, 5}));
		System.out.println(res);
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		ListNode node = head;
		while (node != null) {
			ListNode next = node.next;
			if (next == null || node.val != next.val) {
				cur.next = node;
				cur = cur.next;
				node = node.next;
			} else {
				while (next != null && node.val == next.val) {
					next = next.next;
				}
				node = next;
			}
		}
		cur.next = null;
		return dummy.next;
	}
}
