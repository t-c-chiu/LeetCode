package hard;

import util.ListNode;

public class ReverseNodesInKGroup {
	
	public static void main(String[] args) {
		ListNode res = reverseKGroup(ListNode.generateHead(new int[]{1, 2, 3, 4, 5}), 2);
		System.out.println(res);
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode prev = null, cur = head;
		int i = 0;
		while (i < k && cur != null) {
			prev = cur;
			cur = cur.next;
			i++;
		}
		if (i < k) {
			return head;
		}
		prev.next = null;
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
