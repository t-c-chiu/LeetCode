package medium;

import util.ListNode;

public class RotateList {
	
	public static void main(String[] args) {
		ListNode res = rotateRight(ListNode.generateHead(new int[]{1}), 0);
		System.out.println(res);
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode tail = head;
		int len = 1;
		while (tail.next != null) {
			tail = tail.next;
			len++;
		}
		tail.next = head;
		for (int i = 0; i < len - (k % len); i++) {
			tail = tail.next;
		}
		head = tail.next;
		tail.next = null;
		return head;
	}
	
}
