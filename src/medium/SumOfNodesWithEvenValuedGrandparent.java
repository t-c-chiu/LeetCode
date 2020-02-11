package medium;

import util.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
		int res = new SumOfNodesWithEvenValuedGrandparent().sumEvenGrandparent(root);
		System.out.println(res);
	}
	
	public int sumEvenGrandparent(TreeNode root) {
		return helper(root, null, null);
	}
	
	private int helper(TreeNode current, TreeNode parent, TreeNode grandParent) {
		if (current == null) {
			return 0;
		}
		int sum = grandParent != null && grandParent.val % 2 == 0 ? current.val : 0;
		return sum + helper(current.left, current, parent) + helper(current.right, current, parent);
	}

//	public int sumEvenGrandparent(TreeNode root) {
//		if (root == null) {
//			return 0;
//		}
//		int grandChildrenSum = 0;
//		if (root.val % 2 == 0) {
//			grandChildrenSum = getChildrenSum(root.left) + getChildrenSum(root.right);
//		}
//		return grandChildrenSum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
//	}
//
//	private int getChildrenSum(TreeNode node) {
//		if (node == null) {
//			return 0;
//		}
//		int childrenSum = 0;
//		if (node.left != null) {
//			childrenSum += node.left.val;
//		}
//		if (node.right != null) {
//			childrenSum += node.right.val;
//		}
//		return childrenSum;
//	}
}
