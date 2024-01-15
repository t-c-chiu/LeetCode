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
		pathSum(root, targetSum, res, 0, new ArrayList<>());
		return res;
	}
	
	private static void pathSum(TreeNode node, int targetSum, List<List<Integer>> res, int sum, List<Integer> temp) {
		if (node == null) {
			return;
		}
		sum += node.val;
		temp.add(node.val);
		if (sum == targetSum && isLeaf(node)) {
			res.add(new ArrayList<>(temp));
			temp.remove(temp.size() - 1);
			return;
		}
		pathSum(node.left, targetSum, res, sum, temp);
		pathSum(node.right, targetSum, res, sum, temp);
		temp.remove(temp.size() - 1);
	}
	
	private static boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}
}
