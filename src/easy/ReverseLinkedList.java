package easy;

import util.ListNode;

public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		ListNode result = new ReverseLinkedList().reverseList(listNode1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;

		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}


