package easy;

import util.TreeNode;

public class BalancedBinaryTree {
	
	public static void main(String[] args) {
		boolean res = isBalanced(TreeNode.generateRoot(new Integer[]{3, 9, 20, null, null, 15, 7}));
		System.out.println(res);
	}
	
	public static boolean isBalanced(TreeNode root) {
		return helper(root) != -1;
	}
	
	private static int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = helper(node.left), right = helper(node.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}
