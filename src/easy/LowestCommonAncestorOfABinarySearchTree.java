package easy;

import util.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
	
	public static void main(String[] args) {
	
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int rv = root.val;
		int pv = p.val;
		int qv = q.val;
		if (rv < pv && rv < qv) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (rv > pv && rv > qv) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}
	
}
