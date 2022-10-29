package medium;

import util.ListNode;

public class RotateList {
	
	public static void main(String[] args) {
		ListNode res = rotateRight(ListNode.generateHead(new int[]{1, 2, 3, 4, 5}), 2);
		System.out.println(res);
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		int len = 1;
		ListNode tail = head;
		while (tail.next != null) {
			len++;
			tail = tail.next;
		}
		tail.next = head;
		k = len - k % len;
		while (k > 0) {
			tail = tail.next;
			k--;
		}
		ListNode res = tail.next;
		tail.next = null;
		return res;
	}
}
