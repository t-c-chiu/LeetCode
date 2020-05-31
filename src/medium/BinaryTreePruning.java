package medium;

import util.TreeNode;

public class BinaryTreePruning {
	
	public static void main(String[] args) {
		BinaryTreePruning test = new BinaryTreePruning();
		TreeNode root = TreeNode.generateRoot(new Integer[]{1, 1, 0, 1, 1, 0, 1, 0});
		TreeNode.printVals(test.pruneTree(root));
	}
	
	public TreeNode pruneTree(TreeNode root) {
		if (root == null)
			return null;
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if (root.left == null && root.right == null && root.val == 0)
			return null;
		return root;
	}
}
