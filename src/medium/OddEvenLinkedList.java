package medium;

import util.ListNode;

public class OddEvenLinkedList {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		one.next = new ListNode(2);
		one.next.next = new ListNode(3);
		one.next.next.next = new ListNode(4);
		one.next.next.next.next = new ListNode(5);
		System.out.println(new OddEvenLinkedList().oddEvenList2(one));
	}
	
	// 1 2 3 4 5
	// 1 3 2 4 5
	// 1 3 5 2 4
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return null;
		
		int i = 3;
		ListNode oddTail = head;
		ListNode evenHead = head.next;
		if (evenHead == null)
			return head;
		ListNode evenTail = evenHead;
		ListNode node = evenTail.next;
		while (node != null) {
			ListNode next = node.next;
			if (i % 2 == 1) {
				oddTail.next = node;
				node.next = evenHead;
				evenTail.next = next;
				evenTail = next;
				oddTail = node;
			}
			node = next;
			i++;
		}
		return head;
	}
	
	// 紀錄evenHead 也就是第二個 之後先把odd跟even串起來 odd跟even永遠等於那一串的最後一個 最後再串odd.next=evenHead
	public ListNode oddEvenList2(ListNode head) {
		if (head == null)
			return null;
		ListNode odd = head, even = head.next, evenHead = head.next;
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}
