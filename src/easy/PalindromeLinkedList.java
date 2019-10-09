package easy;

import util.ListNode;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		System.out.println(new PalindromeLinkedList().isPalindrome(ListNode.generateHead(new int[]{1, 2, 2, 1})));
		System.out.println(new PalindromeLinkedList().isPalindrome(ListNode.generateHead(new int[]{1, 2, 3, 2, 1})));
	}
	
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null) {
			if (fast.next == null) {
				slow = slow.next;
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = reverse(slow);
		fast = head;
		while (slow != null) {
			if (slow.val != fast.val)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}
	
	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
