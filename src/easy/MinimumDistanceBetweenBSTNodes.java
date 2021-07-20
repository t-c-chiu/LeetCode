package easy;

import util.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
	
	public static void main(String[] args) {
	}
	
	int pre = -1;
	int min = Integer.MAX_VALUE;
	
	public int minDiffInBST(TreeNode root) {
		if (root.left != null) {
			minDiffInBST(root.left);
		}
		if (pre >= 0) {
			min = Math.min(min, root.val - pre);
		}
		pre = root.val;
		if (root.right != null) {
			minDiffInBST(root.right);
		}
		return min;
	}
	
}
