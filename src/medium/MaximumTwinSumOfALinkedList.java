package medium;

import util.ListNode;

public class MaximumTwinSumOfALinkedList {
	
	public static void main(String[] args) {
		int res = pairSum(ListNode.generateHead(new int[]{5, 4, 2, 1}));
		System.out.println(res);
	}
	
	public static int pairSum(ListNode head) {
		ListNode prev = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		slow = reverse(slow);
		int res = 0;
		while (slow != null) {
			res = Math.max(res, head.val + slow.val);
			head = head.next;
			slow = slow.next;
		}
		return res;
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

//	public static int pairSum(ListNode head) {
//		int n = getLength(head);
//		ListNode right = head;
//		for (int i = 0; i < n / 2; i++) {
//			right = right.next;
//		}
//		ListNode left = reverse(head, n / 2);
//		int res = 0;
//		for (int i = 0; i < n / 2; i++) {
//			res = Math.max(res, left.val + right.val);
//			left = left.next;
//			right = right.next;
//		}
//		return res;
//	}
//
//	private static ListNode reverse(ListNode head, int n) {
//		ListNode pre = null, cur = head, next;
//		while (n > 0) {
//			next = cur.next;
//			cur.next = pre;
//			pre = cur;
//			cur = next;
//			n--;
//		}
//		return pre;
//	}
//
//	private static int getLength(ListNode head) {
//		int length = 0;
//		while (head != null) {
//			length++;
//			head = head.next;
//		}
//		return length;
//	}
}
