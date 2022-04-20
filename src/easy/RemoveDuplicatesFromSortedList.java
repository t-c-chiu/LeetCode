package easy;

import util.ListNode;

public class RemoveDuplicatesFromSortedList {
	
	public static void main(String[] args) {
		ListNode res = deleteDuplicates(ListNode.generateHead(new int[]{1, 1, 2, 3, 3}));
		System.out.println(res);
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		while (node != null) {
			ListNode next = node.next;
			if (next != null && node.val == next.val) {
				node.next = next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}

//	public static ListNode deleteDuplicates(ListNode head) {
//		if (head == null) {
//			return null;
//		}
//		ListNode slow = head, fast = head;
//		while (fast != null) {
//			if (slow.val != fast.val) {
//				slow.next = fast;
//				slow = slow.next;
//			}
//			fast = fast.next;
//		}
//		slow.next = null;
//		return head;
//	}
}
