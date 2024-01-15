package medium;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfBinaryTree {
	
	public static void main(String[] args) {
		int res = widthOfBinaryTree(TreeNode.generateRoot(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, 7}));
		System.out.println(res);
	}
	
	public static int widthOfBinaryTree(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<>();
		map.put(root, 0);
		Deque<TreeNode> dq = new ArrayDeque<>();
		dq.offer(root);
		int res = 0;
		while (!dq.isEmpty()) {
			res = Math.max(res, map.get(dq.peekLast()) - map.get(dq.peekFirst()) + 1);
			for (int i = dq.size(); i > 0; i--) {
				TreeNode node = dq.pollFirst();
				int index = map.get(node);
				if (node.left != null) {
					dq.offerLast(node.left);
					map.put(node.left, index * 2);
				}
				if (node.right != null) {
					dq.offerLast(node.right);
					map.put(node.right, index * 2 + 1);
				}
			}
		}
		return res;
	}
}
