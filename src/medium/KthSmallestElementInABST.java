package medium;

import util.TreeNode;

public class KthSmallestElementInABST {
	
	public static void main(String[] args) {
		int res = kthSmallest(TreeNode.generateRoot(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3);
		System.out.println(res);
	}
	
	static int count, res;
	
	public static int kthSmallest(TreeNode root, int k) {
		helper(root, k);
		return res;
	}
	
	private static void helper(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		helper(root.left, k);
		if (++count == k) {
			res = root.val;
			return;
		}
		helper(root.right, k);
	}
	
}
