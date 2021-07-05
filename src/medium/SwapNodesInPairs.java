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

//	public static ListNode swapPairs(ListNode head) {
//		ListNode dummy = new ListNode(0);
//		dummy.next = head;
//		ListNode pre = dummy;
//		while (pre.next != null && pre.next.next != null) {
//			ListNode cur = pre.next;
//			ListNode next = cur.next;
//			cur.next = next.next;
//			next.next = cur;
//			pre.next = next;
//			pre = cur;
//		}
//		return dummy.next;
//	}
}
