package easy;

import util.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
		assert root != null;
		TreeNode res = lowestCommonAncestor(root, root.left, root.left.right.right);
		System.out.println(res.val);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}
}
