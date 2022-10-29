package medium;

import util.TreeNode;

public class ValidateBinarySearchTree {
	
	public static void main(String[] args) {
		System.out.println(isValidBST(TreeNode.generateRoot(new Integer[]{5, 1, 4, null, null, 3, 6})));
	}
	
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private static boolean isValidBST(TreeNode node, long min, long max) {
		if (node == null) {
			return true;
		}
		if (node.val <= min || node.val >= max) {
			return false;
		}
		return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
	}
}
