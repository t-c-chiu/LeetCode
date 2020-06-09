package medium;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Linked_List_Cycle_II {
	
	public static void main(String[] args) {
		Linked_List_Cycle_II test = new Linked_List_Cycle_II();
		ListNode head = ListNode.generateHead(new int[]{3, 2, 0, 4});
		ListNode second = head.next;
		second.next.next.next = second;
		test.detectCycle(head);
	}
	
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				while (slow != head) {
					slow = slow.next;
					head = head.next;
				}
				return head;
			}
		}
		return null;
	}
}
