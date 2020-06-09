package medium;

import util.ListNode;

public class Remove_Nth_Node_From_End_of_List {
	
	public static void main(String[] args) {
		Remove_Nth_Node_From_End_of_List test = new Remove_Nth_Node_From_End_of_List();
		ListNode res = test.removeNthFromEnd(ListNode.generateHead(new int[]{1, 2}), 1);
		System.out.println(res);
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode start = new ListNode(0), slow = start, fast = start;
		start.next = head;
		while (fast.next != null) {
			if (n > 0) {
				n--;
			} else {
				slow = slow.next;
			}
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return start.next;
	}
}
