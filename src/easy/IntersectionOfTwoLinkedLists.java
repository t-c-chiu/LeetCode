package easy;

import util.ListNode;

public class IntersectionOfTwoLinkedLists {
	public static void main(String[] args) {
		ListNode a = ListNode.generateHead(new int[]{1, 2});
		ListNode b = ListNode.generateHead(new int[]{1, 2, 3});
		ListNode c = ListNode.generateHead(new int[]{5, 6, 7});
		ListNode aTail = a;
		while (aTail.next != null) {
			aTail = aTail.next;
		}
//		aTail.next = c;
		ListNode bTail = b;
		while (bTail.next != null) {
			bTail = bTail.next;
		}
//		bTail.next = c;
		ListNode node = getIntersectionNode(a, b);
		System.out.println(node == c);
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = len(headA);
		int lenB = len(headB);
		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}
		while (lenB > lenA) {
			headB = headB.next;
			lenB--;
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}
	
	private static int len(ListNode node) {
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}
//	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//		ListNode curA = headA, curB = headB;
//		while (curA != curB) {
//			curA = curA == null ? headB : curA.next;
//			curB = curB == null ? headA : curB.next;
//		}
//		return curA;
//	}
}
