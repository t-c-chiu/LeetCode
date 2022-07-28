package medium;

import util.ListNode;

public class PartitionList {
	
	public static void main(String[] args) {
		ListNode res = partition(ListNode.generateHead(new int[]{1, 4, 3, 2, 5, 2}), 3);
		System.out.println(res);
	}
	
	public static ListNode partition(ListNode head, int x) {
		ListNode leftHead = new ListNode(0), leftTail = leftHead, rightHead = new ListNode(0), rightTail = rightHead;
		while (head != null) {
			if (head.val < x) {
				leftTail.next = head;
				leftTail = leftTail.next;
			} else {
				rightTail.next = head;
				rightTail = rightTail.next;
			}
			head = head.next;
		}
		leftTail.next = rightHead.next;
		rightTail.next = null;
		return leftHead.next;
	}
}
