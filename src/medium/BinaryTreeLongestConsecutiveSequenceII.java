package medium;

import util.TreeNode;

public class BinaryTreeLongestConsecutiveSequenceII {
	
	public static void main(String[] args) {
		int res = longestConsecutive(TreeNode.generateRoot(new Integer[]{2, 1, 3}));
		System.out.println(res);
	}
	
	static int max = 0;
	
	public static int longestConsecutive(TreeNode root) {
		longest(root);
		return max;
	}
	
	private static int[] longest(TreeNode node) {
		if (node == null) {
			return new int[]{0, 0};
		}
		
		int increase = 1;
		int decrease = 1;
		if (node.left != null) {
			int[] left = longest(node.left);
			if (node.val == node.left.val + 1) {
				increase = left[0] + 1;
			}
			if (node.val == node.left.val - 1) {
				decrease = left[1] + 1;
			}
		}
		if (node.right != null) {
			int[] right = longest(node.right);
			if (node.val == node.right.val + 1) {
				increase = Math.max(increase, right[0] + 1);
			}
			if (node.val == node.right.val - 1) {
				decrease = Math.max(decrease, right[1] + 1);
			}
		}
		
		max = Math.max(max, increase + decrease - 1);
		return new int[]{increase, decrease};
	}
}
