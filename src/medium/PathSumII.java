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
		pathSum(root, targetSum, res, new ArrayList<>());
		return res;
	}
	
	private static void pathSum(TreeNode node, int targetSum, List<List<Integer>> res, List<Integer> path) {
		if (node == null) {
			return;
		}
		
		path.add(node.val);
		if (targetSum == node.val && isLeaf(node)) {
			res.add(new ArrayList<>(path));
			return;
		}
		
		if (node.left != null) {
			pathSum(node.left, targetSum - node.val, res, path);
			path.remove(path.size() - 1);
		}
		
		if (node.right != null) {
			pathSum(node.right, targetSum - node.val, res, path);
			path.remove(path.size() - 1);
		}
	}
	
	
	private static boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}
}
