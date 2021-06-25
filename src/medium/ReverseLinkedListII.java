package medium;

import util.ListNode;

public class ReverseLinkedListII {
	
	public static void main(String[] args) {
		ListNode head = ListNode.generateHead(new int[]{1, 2, 3, 4, 5});
		ListNode res = reverseBetween(head, 2, 4);
		System.out.println(res);
	}
	
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		while (left > 1) {
			prev = cur;
			cur = cur.next;
			left--;
			right--;
		}
		
		ListNode last = cur;
		ListNode next = cur.next;
		ListNode nextnext;
		while (right > 1) {
			nextnext = next.next;
			next.next = cur;
			cur = next;
			next = nextnext;
			right--;
		}
		last.next = next;
		prev.next = cur;
		return dummy.next;
	}
}
