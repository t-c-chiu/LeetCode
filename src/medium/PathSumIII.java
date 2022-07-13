package medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
	
	public static void main(String[] args) {
		int res = pathSum(TreeNode.generateRoot(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8);
		System.out.println(res);
	}
	
	public static int pathSum(TreeNode root, int targetSum) {
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		return helper(root, 0, targetSum, preSum);
	}
	
	private static int helper(TreeNode node, int sum, int targetSum, Map<Integer, Integer> preSum) {
		if (node == null) {
			return 0;
		}
		sum += node.val;
		int res = preSum.getOrDefault(sum - targetSum, 0);
		preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		res += helper(node.left, sum, targetSum, preSum) + helper(node.right, sum, targetSum, preSum);
		preSum.put(sum, preSum.get(sum) - 1);
		return res;
	}
//	public static int pathSum(TreeNode root, int targetSum) {
//		if (root == null) {
//			return 0;
//		}
//		return helper(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
//	}
//
//	private static int helper(TreeNode node, int targetSum) {
//		if (node == null) {
//			return 0;
//		}
//		targetSum -= node.val;
//		return helper(node.left, targetSum) + helper(node.right, targetSum) + (targetSum == 0 ? 1 : 0);
//	}
}
