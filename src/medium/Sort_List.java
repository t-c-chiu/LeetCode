package medium;

import util.ListNode;

public class Sort_List {
	
	public static void main(String[] args) {
		Sort_List test = new Sort_List();
		ListNode res = test.sortList(ListNode.generateHead(new int[]{4, 2, 1, 3}));
		System.out.println(res);
	}
	
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		head = sortList(head);
		slow = sortList(slow);
		return merge(head, slow);
	}
	
	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0), cur = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null) {
			cur.next = l1;
		}
		if (l2 != null) {
			cur.next = l2;
		}
		return head.next;
	}
}
