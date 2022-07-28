package medium;

import util.ListNode;

public class ReverseLinkedListII {
	
	public static void main(String[] args) {
		ListNode head = ListNode.generateHead(new int[]{1, 2, 3, 4, 5});
		ListNode res = reverseBetween(head, 2, 4);
		System.out.println(res);
	}
	
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(0), prev = null, cur = dummy;
		dummy.next = head;
		for (int i = 0; i < left; i++) {
			prev = cur;
			cur = cur.next;
		}
		ListNode last = null, reversedHead = cur, next;
		for (int i = left; i <= right; i++) {
			next = cur.next;
			cur.next = last;
			last = cur;
			cur = next;
		}
		prev.next = last;
		reversedHead.next = cur;
		return dummy.next;
	}
	
}
