package medium;

import util.TreeNode;

public class InorderSuccessorInBST {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{10, 5, 15, 3, 8, null, null, 2, 4});
		assert root != null;
		TreeNode res = inorderSuccessor(root, root.left.left);
		System.out.println(res);
	}
	
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		while (root != null) {
			if (p.val >= root.val) {
				root = root.right;
			} else {
				res = root;
				root = root.left;
			}
		}
		return res;
	}

//	static TreeNode prev;
//	static TreeNode res;
//
//	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//		if (root == null) {
//			return null;
//		}
//		inorderSuccessor(root.left, p);
//		if (prev == p) {
//			res = root;
//		}
//		prev = root;
//		inorderSuccessor(root.right, p);
//		return res;
//	}


}
