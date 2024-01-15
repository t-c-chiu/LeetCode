package medium;

import util.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	
	public static void main(String[] args) {
		List<List<Integer>> res = zigzagLevelOrder(TreeNode.generateRoot(new Integer[]{3, 9, 20, null, null, 15, 7}));
		System.out.println(res);
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> q = new LinkedList<>();
		q.offer(root);
		boolean odd = true;
		while (!q.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			for (int i = q.size(); i > 0; i--) {
				if (odd) {
					TreeNode node = q.pollFirst();
					list.add(node.val);
					if (node.left != null) {
						q.offerLast(node.left);
					}
					if (node.right != null) {
						q.offerLast(node.right);
					}
				} else {
					TreeNode node = q.pollLast();
					list.add(node.val);
					if (node.right != null) {
						q.offerFirst(node.right);
					}
					if (node.left != null) {
						q.offerFirst(node.left);
					}
				}
			}
			res.add(list);
			odd = !odd;
		}
		return res;
	}

//	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//		List<List<Integer>> res = new ArrayList<>();
//		helper(res, root, true, 0);
//		return res;
//	}
//
//	private static void helper(List<List<Integer>> res, TreeNode node, boolean odd, int level) {
//		if (node == null) {
//			return;
//		}
//		if (res.size() == level) {
//			res.add(new ArrayList<>());
//		}
//		if (odd) {
//			res.get(level).add(node.val);
//		} else {
//			res.get(level).add(0, node.val);
//		}
//		helper(res, node.left, !odd, level + 1);
//		helper(res, node.right, !odd, level + 1);
//	}
}
