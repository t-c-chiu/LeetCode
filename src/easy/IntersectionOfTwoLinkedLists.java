package easy;

import util.ListNode;

public class IntersectionOfTwoLinkedLists {
	public static void main(String[] args) {
		ListNode a1 = new ListNode(11);
		ListNode a2 = new ListNode(12);
		ListNode b1 = new ListNode(21);
		ListNode b2 = new ListNode(22);
		ListNode b3 = new ListNode(23);
		ListNode c1 = new ListNode(31);
		ListNode c2 = new ListNode(32);
		ListNode c3 = new ListNode(33);
		a1.next = a2;
		a2.next = c1;
		b1.next = b2;
		b2.next = b3;
		b3.next = c1;
		c1.next = c2;
		c2.next = c3;
		ListNode node = new IntersectionOfTwoLinkedLists().getIntersectionNode(a1, b1);
		System.out.println(node == c1);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int diff = getLength(headA) - getLength(headB);
		for (int i = 0; i < Math.abs(diff); i++) {
			if (diff > 0)
				headA = headA.next;
			else
				headB = headB.next;
		}
		while (headA != null) {
			if (headA == headB)
				return headA;
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	private int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
}
