package medium;

import util.TreeNode;

public class MaximumProductOfSplittedBinaryTree {
	
	public static void main(String[] args) {
		int res = maxProduct(TreeNode.generateRoot(new Integer[]{1,1}));
		System.out.println(res);
	}
	
	static long res;
	static final int MOD = (int) (Math.pow(10, 9) + 7);
	
	public static int maxProduct(TreeNode root) {
		sum(root);
		dfs(root.val, root);
		return (int) (res % MOD);
	}
	
	private static void dfs(int sum, TreeNode node) {
		if (node == null) {
			return;
		}
		res = Math.max(res, (long) node.val * (sum - node.val));
		dfs(sum, node.left);
		dfs(sum, node.right);
	}
	
	private static int sum(TreeNode node) {
		if (node == null) {
			return 0;
		}
		node.val += sum(node.left) + sum(node.right);
		return node.val;
	}
}
