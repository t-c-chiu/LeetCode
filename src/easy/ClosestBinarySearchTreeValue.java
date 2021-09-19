package easy;

import util.TreeNode;

public class ClosestBinarySearchTreeValue {
	
	public static void main(String[] args) {
		int res = closestValue(TreeNode.generateRoot(new Integer[]{4, 2, 5, 1, 3}), 3.714286);
		System.out.println(res);
	}
	
	public static int closestValue(TreeNode root, double target) {
		int res = 0;
		double diff = Double.MAX_VALUE;
		while (root != null) {
			if (Math.abs(root.val - target) < diff) {
				res = root.val;
				diff = Math.abs(root.val - target);
			}
			if (root.val < target) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return res;
	}
}
