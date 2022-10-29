package hard;

import util.ListNode;

public class MergeKSortedLists {
	
	public static void main(String[] args) {
		ListNode node1 = ListNode.generateHead(new int[]{1, 4, 5});
		ListNode node2 = ListNode.generateHead(new int[]{1, 3, 4});
		ListNode node3 = ListNode.generateHead(new int[]{2, 6});
		ListNode res = mergeKLists(new ListNode[]{node1, node2, node3});
		System.out.println(res);
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		return mergeKLists(lists, 0, lists.length - 1);
	}
	
	private static ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
		if (lo == hi) {
			return lists[lo];
		}
		int mid = (lo + hi) / 2;
		ListNode left = mergeKLists(lists, lo, mid);
		ListNode right = mergeKLists(lists, mid + 1, hi);
		return merge(left, right);
	}
	
	private static ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0), cur = dummy;
		while (left != null && right != null) {
			if (left.val <= right.val) {
				cur.next = left;
				left = left.next;
			} else {
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
		if (left != null) {
			cur.next = left;
		}
		if (right != null) {
			cur.next = right;
		}
		return dummy.next;
	}
}
