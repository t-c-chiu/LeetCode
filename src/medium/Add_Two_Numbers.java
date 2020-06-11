package medium;

import util.ListNode;

public class Add_Two_Numbers {
	
	public static void main(String[] args) {
		Add_Two_Numbers test = new Add_Two_Numbers();
		ListNode res = test.addTwoNumbers(ListNode.generateHead(new int[]{1, 8}), ListNode.generateHead(new int[]{0}));
		System.out.println(res);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0), cur = head;
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
			carry = val > 9 ? 1 : 0;
			ListNode node = new ListNode(val % 10);
			cur.next = node;
			cur = node;
		}
		if (carry == 1) {
			cur.next = new ListNode(1);
		}
		return head.next;
	}
}
