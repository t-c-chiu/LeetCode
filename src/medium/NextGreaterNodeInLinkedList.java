package medium;

import util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
	
	public static void main(String[] args) {
		NextGreaterNodeInLinkedList test = new NextGreaterNodeInLinkedList();
		for (int i : test.nextLargerNodes(ListNode.generateHead(new int[]{2, 1, 5}))) {
			System.out.print(i);
		}
		System.out.println();
		for (int i : test.nextLargerNodes(ListNode.generateHead(new int[]{1, 7, 5, 1, 9, 2, 5, 1}))) {
			System.out.print(i);
		}
	}
	
	public int[] nextLargerNodes(ListNode head) {
		ArrayList<Integer> list = new ArrayList<>();
		for (ListNode node = head; node != null; node = node.next)
			list.add(node.val);
		int[] res = new int[list.size()];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
				res[stack.pop()] = list.get(i);
			}
			stack.push(i);
		}
		return res;
	}
}
