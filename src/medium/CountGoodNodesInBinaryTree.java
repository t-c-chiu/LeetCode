package medium;

import util.TreeNode;

public class CountGoodNodesInBinaryTree {
	
	public static void main(String[] args) {
		int res = goodNodes(TreeNode.generateRoot(new Integer[]{3, 1, 4, 3, null, 1, 5}));
		System.out.println(res);
	}
	
	public static int goodNodes(TreeNode root) {
		return goodNodes(root, Integer.MIN_VALUE);
	}
	
	private static int goodNodes(TreeNode node, int max) {
		if (node == null) {
			return 0;
		}
		return (node.val >= max ? 1 : 0) + goodNodes(node.left, Math.max(max, node.val)) + goodNodes(node.right, Math.max(max, node.val));
	}
}
