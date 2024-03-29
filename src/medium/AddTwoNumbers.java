package medium;

import util.ListNode;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode res = addTwoNumbers(ListNode.generateHead(new int[]{2, 4, 3}), ListNode.generateHead(new int[]{5, 6, 4}));
		System.out.println(res);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0), cur = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int val = carry;
			if (l1 != null) {
				val += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				val += l2.val;
				l2 = l2.next;
			}
			cur.next = new ListNode(val % 10);
			cur = cur.next;
			carry = val / 10;
		}
		if (carry == 1) {
			cur.next = new ListNode(1);
		}
		return dummy.next;
	}
}
