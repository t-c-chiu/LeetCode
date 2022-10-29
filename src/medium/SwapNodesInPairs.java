package medium;

import util.ListNode;

public class SwapNodesInPairs {
	
	public static void main(String[] args) {
		ListNode res = swapPairs(ListNode.generateHead(new int[]{1, 2, 3, 4, 5, 6, 7}));
		System.out.println(res);
	}
	
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
	}
}
