package medium;

import util.TreeNode;

public class LowestCommonAncestorOfABinaryTreeII {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
		TreeNode res = lowestCommonAncestor(root, root.left, root.right);
		System.out.println(res.val);
	}
	
	static boolean pFound;
	static boolean qFound;
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode res = LCA(root, p, q);
		return pFound && qFound ? res : null;
	}
	
	private static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		TreeNode left = LCA(root.left, p, q);
		TreeNode right = LCA(root.right, p, q);
		if (root == p) {
			pFound = true;
			return p;
		}
		if (root == q) {
			qFound = true;
			return q;
		}
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		return root;
	}
}
