package medium;

import util.TreeNode;

public class LongestZigZagPathInABinaryTree {
	
	public static void main(String[] args) {
		int res = longestZigZag(TreeNode.generateRoot(new Integer[]{1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1}));
		System.out.println(res);
	}
	
	static int max = 0;
	
	public static int longestZigZag(TreeNode root) {
		dfs(root.right, 1, true);
		dfs(root.left, 1, false);
		return max;
	}
	
	private static void dfs(TreeNode node, int depth, boolean isRight) {
		if (node == null) {
			return;
		}
		max = Math.max(max, depth);
		if (isRight) {
			dfs(node.left, depth + 1, false);
			dfs(node.right, 1, true);
		} else {
			dfs(node.right, depth + 1, true);
			dfs(node.left, 1, false);
		}
	}
	
}
