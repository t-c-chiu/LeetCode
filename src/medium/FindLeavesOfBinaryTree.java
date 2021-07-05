package medium;

import util.TreeNode;

import java.util.*;

public class FindLeavesOfBinaryTree {
	
	public static void main(String[] args) {
		List<List<Integer>> res = findLeaves(TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, 5}));
		System.out.println(res);
	}
	
	public static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		calculateHeight(root, res);
		return res;
	}
	
	private static int calculateHeight(TreeNode root, List<List<Integer>> res) {
		if (root == null) {
			return -1;
		}
		int height = Math.max(calculateHeight(root.left, res), calculateHeight(root.right, res)) + 1;
		if (res.size() <= height) {
			res.add(new ArrayList<>());
		}
		res.get(height).add(root.val);
		return height;
	}
//	public static List<List<Integer>> findLeaves(TreeNode root) {
//		TreeNode dummy = new TreeNode(-1);
//		dummy.left = root;
//		List<List<Integer>> res = new ArrayList<>();
//		while (!isLeaf(dummy.left)) {
//			ArrayList<Integer> list = new ArrayList<>();
//			findLeaves(root, list);
//			res.add(list);
//		}
//		res.add(Collections.singletonList(root.val));
//		return res;
//	}
//
//	private static void findLeaves(TreeNode node, List<Integer> list) {
//		if (node == null) {
//			return;
//		}
//		if (node.left != null && isLeaf(node.left)) {
//			list.add(node.left.val);
//			node.left = null;
//		}
//		if (node.right != null && isLeaf(node.right)) {
//			list.add(node.right.val);
//			node.right = null;
//		}
//		findLeaves(node.left, list);
//		findLeaves(node.right, list);
//	}
//
//	private static boolean isLeaf(TreeNode node) {
//		return node.left == null && node.right == null;
//	}
	
}
