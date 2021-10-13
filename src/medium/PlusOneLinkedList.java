package medium;

import util.ListNode;

public class PlusOneLinkedList {
	
	public static void main(String[] args) {
		ListNode res = plusOne(ListNode.generateHead(new int[]{9,9,9,9,9}));
		System.out.println(res);
	}
	
	public static ListNode plusOne(ListNode head) {
		boolean plus = plus(head);
		if (plus) {
			ListNode node = new ListNode(1);
			node.next = head;
			return node;
		}
		return head;
	}
	
	private static boolean plus(ListNode node) {
		if (node == null) {
			return true;
		}
		boolean plus = plus(node.next);
		if (plus) {
			if (node.val == 9) {
				node.val = 0;
				return true;
			}
			node.val++;
		}
		return false;
	}
}
