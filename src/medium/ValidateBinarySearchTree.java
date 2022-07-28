package medium;

import util.TreeNode;

public class ValidateBinarySearchTree {
	
	public static void main(String[] args) {
		System.out.println(isValidBST(TreeNode.generateRoot(new Integer[]{5, 1, 4, null, null, 3, 6})));
	}
	
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private static boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		int val = root.val;
		if (val <= min || val >= max) {
			return false;
		}
		return isValidBST(root.left, min, val) && isValidBST(root.right, root.val, max);
	}
}
