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
	
	private static int helper(TreeNode node, int sum, int target, Map<Integer, Integer> preSum) {
		if (node == null) {
			return 0;
		}
		
		sum += node.val;
		int res = preSum.getOrDefault(sum - target, 0);
		preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		
		res += helper(node.left, sum, target, preSum) + helper(node.right, sum, target, preSum);
		preSum.put(sum, preSum.get(sum) - 1);
		return res;
	}
}
