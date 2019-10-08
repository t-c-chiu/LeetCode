package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal test = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = test.zigzagLevelOrder(root);
		System.out.println(res);
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		boolean evenLevel = true;
		while (!deque.isEmpty()) {
			int size = deque.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node;
				if (evenLevel) {
					node = deque.removeFirst();
					if (node.left != null)
						deque.addLast(node.left);
					if (node.right != null)
						deque.addLast(node.right);
				} else {
					node = deque.removeLast();
					if (node.right != null)
						deque.addFirst(node.right);
					if (node.left != null)
						deque.addFirst(node.left);
				}
				list.add(node.val);
			}
			res.add(list);
			evenLevel = !evenLevel;
		}
		return res;
	}
}
