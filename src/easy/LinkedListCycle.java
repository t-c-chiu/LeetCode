package easy;

import util.ListNode;

public class LinkedListCycle {

	public static void main(String[] args) {
		LinkedListCycle linkedListCycle = new LinkedListCycle();

		ListNode head1 = new ListNode(0);
		head1.next = new ListNode(1);
		head1.next.next = new ListNode(2);
		head1.next.next.next = head1;
		System.out.println(linkedListCycle.hasCycle(head1));

		ListNode head2 = new ListNode(0);
		head2.next = new ListNode(1);
		head2.next.next = new ListNode(2);
		System.out.println(linkedListCycle.hasCycle(head2));
	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}
