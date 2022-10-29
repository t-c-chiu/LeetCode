package easy;

import util.TreeNode;

public class SubtreeOfAnotherTree {
	
	public static void main(String[] args) {
		boolean res = isSubtree(
				TreeNode.generateRoot(new Integer[]{3, 4, 5, 1, 2}),
				TreeNode.generateRoot(new Integer[]{4, 1, 2}));
		System.out.println(res);
	}
	
	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}
		if (isSame(root, subRoot)) {
			return true;
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}
	
	private static boolean isSame(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		}
		if (root == null || subRoot == null) {
			return false;
		}
		return root.val == subRoot.val && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
	}
	
}
