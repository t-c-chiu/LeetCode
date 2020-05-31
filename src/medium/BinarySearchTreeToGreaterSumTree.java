package medium;

import util.TreeNode;

public class BinarySearchTreeToGreaterSumTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		TreeNode treeNode = new BinarySearchTreeToGreaterSumTree().bstToGst(root);
	}

	private int sum = 0;

	public TreeNode bstToGst(TreeNode root) {
		if (root == null)
			return null;

		bstToGst(root.right);
		root.val += sum;
		sum = root.val;
		bstToGst(root.left);
		return root;
	}
}
