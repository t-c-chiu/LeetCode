package util;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x) {
		val = x;
	}
	
	public static ListNode generateHead(int[] vals) {
		if (vals.length == 0)
			return null;
		
		ListNode head = new ListNode(vals[0]);
		ListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current.next = new ListNode(vals[i]);
			current = current.next;
		}
		return head;
	}
	
	@Override
	public String toString() {
		return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}
}
