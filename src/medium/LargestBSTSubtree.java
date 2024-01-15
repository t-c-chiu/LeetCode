package medium;

import util.TreeNode;

public class LargestBSTSubtree {
	
	public static void main(String[] args) {
		int res = largestBSTSubtree(TreeNode.generateRoot(new Integer[]{10, 5, 15, 1, 8, null, 7}));
		System.out.println(res);
	}
	
	public static int largestBSTSubtree(TreeNode root) {
		return helper(root).count;
	}
	
	private static MinMaxCount helper(TreeNode node) {
		if (node == null) {
			return new MinMaxCount(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}
		MinMaxCount left = helper(node.left);
		MinMaxCount right = helper(node.right);
		if (left.max < node.val && right.min > node.val) {
			return new MinMaxCount(Math.min(left.min, node.val), Math.max(right.max, node.val), left.count + right.count + 1);
		} else {
			return new MinMaxCount(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.count, right.count));
		}
	}
	
	static class MinMaxCount {
		int min;
		int max;
		int count;
		
		public MinMaxCount(int min, int max, int count) {
			this.min = min;
			this.max = max;
			this.count = count;
		}
	}
}
