package medium;

import util.TreeNode;

public class BinaryTreePruning {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{1, 1, 0, 1, 1, 0, 1, 0});
		TreeNode.printVals(pruneTree(root));
	}
	
	public static TreeNode pruneTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		return root.left == null && root.right == null && root.val == 0 ? null : root;
	}
}
