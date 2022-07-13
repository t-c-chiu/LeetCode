package medium;

import util.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
		TreeNode res = lowestCommonAncestor(root, root.left.right.left, root.left.left);
		System.out.println(res);
	}
	
	//       3
	//   5       1
	// 6   2   0   8
	//    7 4
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}
}
