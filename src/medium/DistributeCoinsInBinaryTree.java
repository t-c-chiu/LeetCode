package medium;

import util.TreeNode;

public class DistributeCoinsInBinaryTree {
	
	public static void main(String[] args) {
		DistributeCoinsInBinaryTree test = new DistributeCoinsInBinaryTree();
		int res = test.distributeCoins(TreeNode.generateRoot(new Integer[]{3, 0, 0}));
		System.out.println(res);
		res = test.distributeCoins(TreeNode.generateRoot(new Integer[]{0, 3, 0}));
		System.out.println(res);
		res = test.distributeCoins(TreeNode.generateRoot(new Integer[]{1, 0, 0, null, 3}));
		System.out.println(res);
	}
	
	public int distributeCoins(TreeNode root) {
		int res = 0;
		TreeNode left = root.left, right = root.right;
		if (left != null) {
			res += distributeCoins(left);
			root.val += left.val - 1;
			res += Math.abs(left.val - 1);
		}
		if (right != null) {
			res += distributeCoins(right);
			root.val += right.val - 1;
			res += Math.abs(right.val - 1);
		}
		return res;
	}
}
