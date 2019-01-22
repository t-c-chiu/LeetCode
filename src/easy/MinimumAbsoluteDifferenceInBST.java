package easy;

import util.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		System.out.println(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(root));
	}

	// 1
	//  \
	//   5
	//  /
	// 4
	private int min = Integer.MAX_VALUE;
	private int preValue = -1;

	public int getMinimumDifference(TreeNode root) {
		int val = root.val;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (left != null)
			getMinimumDifference(left);
		if (preValue != -1)
			min = Math.min(min, val - preValue);
		preValue = val;
		if (right != null)
			getMinimumDifference(right);
		return min;
	}
}
