package easy;

import util.TreeNode;

public class UnivaluedBinaryTree {
	public static void main(String[] args) {
		UnivaluedBinaryTree univaluedBinaryTree = new UnivaluedBinaryTree();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		System.out.println(univaluedBinaryTree.isUnivalTree(root));
		root.left.left = new TreeNode(1);
		System.out.println(univaluedBinaryTree.isUnivalTree(root));

	}

	public boolean isUnivalTree(TreeNode root) {
		return helper(root, root.val);
	}

	private boolean helper(TreeNode root, int val) {
		if (root == null)
			return true;
		if (root.val != val)
			return false;
		return helper(root.left, val) && helper(root.right, val);
	}
}
