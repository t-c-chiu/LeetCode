package easy;

import java.util.Stack;

import util.ListNode;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);

		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(1);
		System.out.println(new PalindromeLinkedList().isPalindrome(head));
		System.out.println(new PalindromeLinkedList().isPalindrome(head2));
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;

		Stack<Integer> stack = new Stack<>();
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null) {
			if (fast.next == null) {
				slow = slow.next;
				break;
			}
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		while (slow != null) {
			if (stack.isEmpty() || stack.pop() != slow.val)
				return false;
			slow = slow.next;
		}
		return true;
	}
}
