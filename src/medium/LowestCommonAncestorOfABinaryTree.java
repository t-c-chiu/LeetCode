package medium;

import util.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
	
	public static void main(String[] args) {
		LowestCommonAncestorOfABinaryTree test = new LowestCommonAncestorOfABinaryTree();
		TreeNode root = TreeNode.generateRoot(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
		test.lowestCommonAncestor(root, root.left.right.left, root.left.left);// 7, 6
	}
	
	//       3
	//   5       1
	// 6   2   0   8
	//    7 4
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null)
			return right;
		if (right == null)
			return left;
		return root;
	}
}
