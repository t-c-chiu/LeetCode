package medium;

import util.ListNode;

public class LinkedListCycleII {
	
	public static void main(String[] args) {
		ListNode head = ListNode.generateHead(new int[]{3, 2, 0, 4});
		ListNode second = head.next;
		second.next.next.next = second;
		ListNode res = detectCycle(head);
		System.out.println(res.val);
	}
	
	public static ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
			if (slow == fast) {
				break;
			}
		}
		return slow;
	}
}
