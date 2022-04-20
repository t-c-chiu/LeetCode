package medium;

import util.ListNode;

public class SplitLinkedListInParts {
	
	public static void main(String[] args) {
		ListNode[] res = splitListToParts(ListNode.generateHead(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 3);
		for (ListNode listNode : res) {
			System.out.println(listNode);
		}
	}
	
	public static ListNode[] splitListToParts(ListNode head, int k) {
		ListNode[] res = new ListNode[k];
		int size = getSize(head);
		int i = 0;
		ListNode cur = head;
		while (i < k && cur != null) {
			int curSize = size / k + (size % k > i ? 1 : 0);
			res[i] = cur;
			for (int j = 1; j < curSize && cur != null; j++) {
				cur = cur.next;
			}
			if (cur != null) {
				ListNode next = cur.next;
				cur.next = null;
				cur = next;
			}
			i++;
		}
		return res;
	}
	
	private static int getSize(ListNode head) {
		int size = 0;
		while (head != null) {
			size++;
			head = head.next;
		}
		return size;
	}
}
