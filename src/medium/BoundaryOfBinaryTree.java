package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
	
	public static void main(String[] args) {
		List<Integer> res = boundaryOfBinaryTree(TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10}));
		System.out.println(res);
	}
	
	public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		res.add(root.val);
		leftBoundary(res, root.left);
		leaves(res, root.left);
		leaves(res, root.right);
		rightBoundary(res, root.right);
		return res;
	}
	
	private static void leftBoundary(List<Integer> res, TreeNode node) {
		if (node == null || isLeaf(node)) {
			return;
		}
		res.add(node.val);
		if (node.left != null) {
			leftBoundary(res, node.left);
		} else {
			leftBoundary(res, node.right);
		}
	}
	
	private static void rightBoundary(List<Integer> res, TreeNode node) {
		if (node == null || isLeaf(node)) {
			return;
		}
		if (node.right != null) {
			rightBoundary(res, node.right);
		} else {
			rightBoundary(res, node.left);
		}
		res.add(node.val);
	}
	
	private static void leaves(List<Integer> res, TreeNode node) {
		if (node == null) {
			return;
		}
		if (isLeaf(node)) {
			res.add(node.val);
			return;
		}
		leaves(res, node.left);
		leaves(res, node.right);
	}
	
	private static boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}
}
