package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	
	public static void main(String[] args) {
		List<List<Integer>> res = pathSum(TreeNode.generateRoot(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
		System.out.println(res);
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, root, targetSum, new ArrayList<>());
		return res;
	}
	
	private static void helper(List<List<Integer>> res, TreeNode node, int targetSum, List<Integer> temp) {
		if (node == null) {
			return;
		}
		int val = node.val;
		temp.add(val);
		targetSum -= val;
		if (targetSum == 0 && isLeaf(node)) {
			res.add(new ArrayList<>(temp));
		}
		helper(res, node.left, targetSum, temp);
		helper(res, node.right, targetSum, temp);
		temp.remove(temp.size() - 1);
	}
	
	private static boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}
}
