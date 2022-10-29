package easy;

import util.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
		TreeNode res = lowestCommonAncestor(root, root.left, root.right);
		System.out.println(res.val);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}
}
