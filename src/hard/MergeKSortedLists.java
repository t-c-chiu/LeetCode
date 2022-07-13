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
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
		for (ListNode list : lists) {
			if (list != null) {
				pq.offer(list);
			}
		}
		while (!pq.isEmpty()) {
			ListNode poll = pq.poll();
			cur.next = poll;
			cur = cur.next;
			if (poll.next != null) {
				pq.offer(poll.next);
			}
		}
		return dummy.next;
	}
}
