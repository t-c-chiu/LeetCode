package medium;

import util.TreeNode;

public class HouseRobberIII {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(5);
		left.left = new TreeNode(1);
		left.right = new TreeNode(3);
		right.right = new TreeNode(1);
		root.left = left;
		root.right = right;
		System.out.println(rob(root));
	}
	
	public static int rob(TreeNode node) {
		int[] res = helper(node);
		return Math.max(res[0], res[1]);
	}
	
	private static int[] helper(TreeNode node) {
		if (node == null) {
			return new int[2];
		}
		int[] left = helper(node.left);
		int[] right = helper(node.right);
		return new int[]{Math.max(left[0], left[1]) + Math.max(right[0], right[1]), node.val + left[0] + right[0]};
	}
//	static Map<TreeNode, Integer> cache = new HashMap<>();
//
//	public static int rob(TreeNode node) {
//		if (node == null) {
//			return 0;
//		}
//		if (cache.containsKey(node)) {
//			return cache.get(node);
//		}
//		int val = 0;
//		if (node.left != null) {
//			val += rob(node.left.left) + rob(node.left.right);
//		}
//		if (node.right != null) {
//			val += rob(node.right.left) + rob(node.right.right);
//		}
//		val = Math.max(val + node.val, rob(node.left) + rob(node.right));
//		cache.put(node, val);
//		return val;
//	}
	
}
