package medium;

import util.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
		int res = sumEvenGrandparent(root);
		System.out.println(res);
	}
	
	public static int sumEvenGrandparent(TreeNode root) {
		return helper(root, null, null);
	}
	
	private static int helper(TreeNode current, TreeNode parent, TreeNode grandParent) {
		if (current == null) {
			return 0;
		}
		int sum = grandParent != null && grandParent.val % 2 == 0 ? current.val : 0;
		return sum + helper(current.left, current, parent) + helper(current.right, current, parent);
	}

//	public static int sumEvenGrandparent(TreeNode root) {
//		if (root == null) {
//			return 0;
//		}
//		int sum = 0;
//		if (root.val % 2 == 0) {
//			sum = sum(root);
//		}
//		return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
//	}
//
//	private static int sum(TreeNode node) {
//		int sum = 0;
//		TreeNode left = node.left;
//		if (left != null) {
//			if (left.left != null) {
//				sum += left.left.val;
//			}
//			if (left.right != null) {
//				sum += left.right.val;
//			}
//		}
//		TreeNode right = node.right;
//		if (right != null) {
//			if (right.left != null) {
//				sum += right.left.val;
//			}
//			if (right.right != null) {
//				sum += right.right.val;
//			}
//		}
//		return sum;
//	}
}
