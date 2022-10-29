package medium;

import util.ListNode;

public class ReverseLinkedListII {
	
	public static void main(String[] args) {
		ListNode head = ListNode.generateHead(new int[]{1, 2});
		ListNode res = reverseBetween(head, 1, 2);
		System.out.println(res);
	}
	
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(0), cur = dummy, prev = null;
		dummy.next = head;
		for (int i = 0; i < left; i++) {
			prev = cur;
			cur = cur.next;
		}
		ListNode last = null, midHead = cur, next;
		for (int i = 0; i <= right - left; i++) {
			next = cur.next;
			cur.next = last;
			last = cur;
			cur = next;
		}
		prev.next = last;
		midHead.next = cur;
		return dummy.next;
	}
	
}
