package medium;

import util.TreeNode;

public class AddOneRowToTree {
	
	public static void main(String[] args) {
		TreeNode res = addOneRow(TreeNode.generateRoot(new Integer[]{4, 2, 6, 3, 1, 5}), 1, 2);
		TreeNode.printVals(res);
	}
	
	public static TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth == 1) {
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}
		helper(root, val, depth - 1);
		return root;
	}
	
	private static void helper(TreeNode node, int val, int depth) {
		if (node == null) {
			return;
		}
		if (depth == 1) {
			TreeNode oldLeft = node.left;
			TreeNode oldRight = node.right;
			node.left = new TreeNode(val);
			node.right = new TreeNode(val);
			node.left.left = oldLeft;
			node.right.right = oldRight;
			return;
		}
		helper(node.left, val, depth - 1);
		helper(node.right, val, depth - 1);
	}
}
