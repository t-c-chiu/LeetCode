package medium;

import util.TreeNode;

public class InorderSuccessorInBST {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
		assert root != null;
		TreeNode res = inorderSuccessor(root, root.left);
		System.out.println(res);
	}
	
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode cur = root, res = null;
		while (cur != null) {
			if (cur.val > p.val) {
				res = cur;
				cur = cur.left;
			} else {
				cur = cur.right;
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
