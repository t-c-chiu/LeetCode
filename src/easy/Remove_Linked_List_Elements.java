package easy;

import util.ListNode;

public class Remove_Linked_List_Elements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		removeElements(head, head.next, val);
		return head.val == val ? head.next : head;
	}
	
	private void removeElements(ListNode head, ListNode next, int val) {
		if (next == null)
			return;
		if (next.val == val) {
			head.next = next.next;
			removeElements(head, head.next, val);
		} else
			removeElements(next, next.next, val);
	}
	
	public ListNode removeElements2(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
				continue;
			}
			cur = cur.next;
		}
		return head.val == val ? head.next : head;
	}
}
