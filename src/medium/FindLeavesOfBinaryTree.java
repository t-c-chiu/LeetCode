package medium;

import util.TreeNode;

import java.util.*;

public class FindLeavesOfBinaryTree {
	
	public static void main(String[] args) {
		List<List<Integer>> res = findLeaves(TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, 5}));
		System.out.println(res);
	}
	
	public static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, root);
		return res;
	}
	
	private static int dfs(List<List<Integer>> res, TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = dfs(res, node.left);
		int right = dfs(res, node.right);
		int depth = Math.max(left, right);
		if (res.size() == depth) {
			res.add(new ArrayList<>());
		}
		res.get(depth).add(node.val);
		return depth + 1;
	}
}
