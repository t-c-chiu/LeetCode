package easy;

import util.ListNode;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		System.out.println(isPalindrome(ListNode.generateHead(new int[]{1})));
		System.out.println(isPalindrome(ListNode.generateHead(new int[]{1, 2, 3, 2, 1})));
	}
	
	public static boolean isPalindrome(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		slow = reverse(slow);
		while (slow != null) {
			if (slow.val != head.val) {
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		return true;
	}
	
	private static ListNode reverse(ListNode node) {
		ListNode prev = null, cur = node, next;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}
