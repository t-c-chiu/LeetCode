package medium;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumWidthOfBinaryTree {
	
	public static void main(String[] args) {
		int res = widthOfBinaryTree(TreeNode.generateRoot(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, 7}));
		System.out.println(res);
	}
	
	public static int widthOfBinaryTree(TreeNode root) {
		Deque<TreeNode> deque = new ArrayDeque<>();
		root.val = 0;
		deque.offer(root);
		int res = 0;
		while (!deque.isEmpty()) {
			res = Math.max(res, deque.peekLast().val - deque.peekFirst().val + 1);
			for (int i = deque.size(); i > 0; i--) {
				TreeNode cur = deque.pollFirst();
				if (cur.left != null) {
					cur.left.val = cur.val * 2;
					deque.offerLast(cur.left);
				}
				if (cur.right != null) {
					cur.right.val = cur.val * 2 + 1;
					deque.offerLast(cur.right);
				}
			}
		}
		return res;
	}
}
