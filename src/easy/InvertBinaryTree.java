package easy;

import util.TreeNode;

public class InvertBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		TreeNode result = new InvertBinaryTree().invertTree(root);
		System.out.println(result.val);
		System.out.println(result.left.val);
		System.out.println(result.left.left.val);
		System.out.println(result.left.right.val);
		System.out.println(result.right.val);
		System.out.println(result.right.left.val);
		System.out.println(result.right.right.val);
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode result = new TreeNode(root.val);
		result.left = invertTree(root.right);
		result.right = invertTree( root.left);
		return result;
	}
}
