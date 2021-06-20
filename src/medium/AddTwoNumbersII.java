package medium;

import util.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
	
	public static void main(String[] args) {
		ListNode res = addTwoNumbers(ListNode.generateHead(new int[]{7, 2, 4, 3}), ListNode.generateHead(new int[]{5, 6, 4}));
		System.out.println(res);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		int carry = 0;
		ListNode head = null;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			int num1 = s1.isEmpty() ? 0 : s1.pop();
			int num2 = s2.isEmpty() ? 0 : s2.pop();
			int sum = num1 + num2 + carry;
			ListNode node = new ListNode(sum % 10);
			node.next = head;
			head = node;
			carry = sum / 10;
		}
		if (carry > 0) {
			ListNode node = new ListNode(1);
			node.next = head;
			head = node;
		}
		return head;
	}
}
