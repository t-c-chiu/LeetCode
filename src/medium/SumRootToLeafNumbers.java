package medium;

import util.TreeNode;

public class SumRootToLeafNumbers {
	
	public static void main(String[] args) {
		int res = sumNumbers(TreeNode.generateRoot(new Integer[]{4, 9, 0, 5, 1}));
		System.out.println(res);
	}
	
	public static int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}
	
	private static int dfs(TreeNode node, int val) {
		if (node == null) {
			return 0;
		}
		val = val * 10 + node.val;
		if (isLeaf(node)) {
			return val;
		}
		return dfs(node.left, val) + dfs(node.right, val);
	}
	
	private static boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}
}
