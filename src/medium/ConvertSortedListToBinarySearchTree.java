package medium;

import util.ListNode;
import util.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	
	public static void main(String[] args) {
		TreeNode res = sortedListToBST(ListNode.generateHead(new int[]{-10, -3, 0, 5, 9}));
		System.out.println(res);
	}
	
	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		return toBST(head, null);
	}
	
	private static TreeNode toBST(ListNode head, ListNode tail) {
		if (head == tail) {
			return null;
		}
		ListNode fast = head, slow = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = toBST(head, slow);
		node.right = toBST(slow.next, tail);
		return node;
	}
}
