package medium;

import util.TreeNode;

public class Maximum_Difference_Between_Node_and_Ancestor {
	
	public static void main(String[] args) {
		Maximum_Difference_Between_Node_and_Ancestor test = new Maximum_Difference_Between_Node_and_Ancestor();
		int res = test.maxAncestorDiff(TreeNode.generateRoot(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13}));
		System.out.println(res);
	}
	
	public int maxAncestorDiff(TreeNode root) {
		return maxAncestorDiff(root, root.val, root.val);
	}
	
	private int maxAncestorDiff(TreeNode root, int max, int min) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		
		int res = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
		max = Math.max(max, root.val);
		min = Math.min(min, root.val);
		return Math.max(res, Math.max(maxAncestorDiff(root.left, max, min), maxAncestorDiff(root.right, max, min)));
	}
}
