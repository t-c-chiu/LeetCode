package hard;

import util.TreeNode;

public class BinaryTreeMaximumPathSum {
	
	public static void main(String[] args) {
		int res = maxPathSum(TreeNode.generateRoot(new Integer[]{15, 9, 20, null, null, 15, 7}));
		System.out.println(res);
	}
	
	static int res = Integer.MIN_VALUE;
	
	public static int maxPathSum(TreeNode root) {
		dfs(root);
		return res;
	}
	
	private static int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int val = node.val;
		int left = dfs(node.left);
		int right = dfs(node.right);
		res = Math.max(res, left + right + val);
		return Math.max(0, Math.max(left, right) + val);
	}
	
}
