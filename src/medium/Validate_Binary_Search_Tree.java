package medium;

import util.TreeNode;

public class Validate_Binary_Search_Tree {
	
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public boolean isValidBST(TreeNode root, long low, long high) {
		if (root == null)
			return true;
		int val = root.val;
		if (val <= low || val >= high)
			return false;
		return isValidBST(root.left, low, val) && isValidBST(root.right, val, high);
	}
}
