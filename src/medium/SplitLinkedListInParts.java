package medium;

import util.ListNode;

public class SplitLinkedListInParts {
	
	public static void main(String[] args) {
		ListNode[] res = splitListToParts(ListNode.generateHead(new int[]{1, 2, 3}), 5);
		for (ListNode listNode : res) {
			System.out.println(listNode);
		}
	}
	
	public static ListNode[] splitListToParts(ListNode head, int k) {
		ListNode[] res = new ListNode[k];
		int size = getSize(head), eachSize = size / k, addOne = size % k;
		ListNode cur = head;
		for (int i = 0; i < k && cur != null; i++, addOne--) {
			res[i] = cur;
			for (int j = 1; j < eachSize + (addOne > 0 ? 1 : 0) && cur != null; j++) {
				cur = cur.next;
			}
			if (cur != null) {
				ListNode next = cur.next;
				cur.next = null;
				cur = next;
			}
		}
		return res;
	}
	
	private static int getSize(ListNode node) {
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;
	}
}
