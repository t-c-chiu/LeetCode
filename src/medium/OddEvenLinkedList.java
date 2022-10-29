package medium;

import util.ListNode;

public class OddEvenLinkedList {
	public static void main(String[] args) {
		System.out.println(oddEvenList(ListNode.generateHead(new int[]{1})));
	}
	
	public static ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}
