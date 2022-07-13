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
		Deque<TreeNode> dq = new ArrayDeque<>();
		boolean odd = true;
		dq.offer(root);
		while (!dq.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			for (int i = dq.size(); i > 0; i--) {
				if (odd) {
					TreeNode cur = dq.pollFirst();
					list.add(cur.val);
					if (cur.left != null) {
						dq.offerLast(cur.left);
					}
					if (cur.right != null) {
						dq.offerLast(cur.right);
					}
				} else {
					TreeNode cur = dq.pollLast();
					list.add(cur.val);
					if (cur.right != null) {
						dq.offerFirst(cur.right);
					}
					if (cur.left != null) {
						dq.offerFirst(cur.left);
					}
				}
			}
			odd = !odd;
			res.add(list);
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
