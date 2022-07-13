package medium;

import util.TreeNode;

public class LargestBSTSubtree {
	
	public static void main(String[] args) {
		int res = largestBSTSubtree(TreeNode.generateRoot(new Integer[]{10, 5, 15, 1, 8, null, 7}));
		System.out.println(res);
	}
	
	/**
	 * [0] = min
	 * [1] = max
	 * [2] = largestBSTSubtree
	 */
	public static int largestBSTSubtree(TreeNode root) {
		return helper(root)[2];
	}
	
	private static int[] helper(TreeNode node) {
		if (node == null) {
			return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
		}
		int[] left = helper(node.left);
		int[] right = helper(node.right);
		if (left[1] < node.val && node.val < right[0]) {
			return new int[]{Math.min(left[0], node.val), Math.max(right[1], node.val), left[2] + right[2] + 1};
		} else {
			return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
		}
	}
}
