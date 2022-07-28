package medium;

import util.TreeNode;

public class KthSmallestElementInABST {
	
	
	static int res, count;
	
	public static int kthSmallest(TreeNode root, int k) {
		helper(root, k);
		return res;
	}
	
	private static void helper(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		helper(root.left, k);
		if (++count == k) {
			res = root.val;
			return;
		}
		helper(root.right, k);
	}
}
