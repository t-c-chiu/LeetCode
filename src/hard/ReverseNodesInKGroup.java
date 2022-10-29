package hard;

import util.ListNode;

public class ReverseNodesInKGroup {
	
	public static void main(String[] args) {
		ListNode res = reverseKGroup(ListNode.generateHead(new int[]{1, 2, 3, 4, 5, 6, 7}), 3);
		System.out.println(res);
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		int len = 0;
		ListNode pre = null, cur = head;
		while (cur != null && len < k) {
			pre = cur;
			cur = cur.next;
			len++;
		}
		if (len < k) {
			return head;
		}
		pre.next = null;
		ListNode newHead = reverse(head);
		head.next = reverseKGroup(cur, k);
		return newHead;
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
}
