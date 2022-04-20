package medium;

import util.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
	
	public static void main(String[] args) {
		List<List<Integer>> res = levelOrderBottom(TreeNode.generateRoot(new Integer[]{3, 9, 20, null, null, 15, 7}));
		System.out.println(res);
	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				list.add(poll.val);
				if (poll.left != null) {
					queue.offer(poll.left);
				}
				if (poll.right != null) {
					queue.offer(poll.right);
				}
			}
			res.add(0, list);
		}
		return res;
	}
}
