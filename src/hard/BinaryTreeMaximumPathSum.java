package hard;

import util.TreeNode;

public class BinaryTreeMaximumPathSum {
	
	public static void main(String[] args) {
		int res = maxPathSum(TreeNode.generateRoot(new Integer[]{15, 9, 20, null, null, 15, 7}));
		System.out.println(res);
	}
	
	static int res = Integer.MIN_VALUE;
	
	public static int maxPathSum(TreeNode root) {
		helper(root);
		return res;
	}
	
	private static int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = helper(node.left);
		int right = helper(node.right);
		res = Math.max(res, left + right + node.val);
		return Math.max(0, Math.max(left, right) + node.val);
	}
}
