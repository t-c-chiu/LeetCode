package hard;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	public static void main(String[] args) {
		ListNode node1 = ListNode.generateHead(new int[]{1, 4, 5});
		ListNode node2 = ListNode.generateHead(new int[]{1, 3, 4});
		ListNode node3 = ListNode.generateHead(new int[]{2, 6});
		ListNode res = mergeKLists(new ListNode[]{node1, node2, node3});
		System.out.println(res);
	}
	
	/**
	 * 1 4 5
	 * 1 3 4
	 * 2 6
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
		for (ListNode node : lists) {
			if (node != null) {
				queue.offer(node);
			}
		}
		if (queue.isEmpty()) {
			return null;
		}
		
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			cur.next = node;
			cur = node;
			if (node.next != null) {
				queue.offer(node.next);
			}
		}
		return head.next;
	}
}
