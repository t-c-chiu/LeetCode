package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree {
	
	public static void main(String[] args) {
		int res = widthOfBinaryTree(TreeNode.generateRoot(new Integer[]{1, 1, 1, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, null, 1, 1, null, 1, null, 1, null, 1, null, 1, null}));
		System.out.println(res);
	}
	
	/**
	 * list.get(i)[0] = the smallest order at level i
	 * list.get(i)[1] = the largest order at level i
	 */
	public static int widthOfBinaryTree(TreeNode root) {
		List<long[]> list = new ArrayList<>();
		dfs(root, 1, 0, list);
		long res = 0;
		for (long[] lr : list) {
			res = Math.max(res, lr[1] - lr[0] + 1);
		}
		return (int) res;
	}
	
	private static void dfs(TreeNode node, long order, int level, List<long[]> list) {
		if (node == null) {
			return;
		}
		if (list.size() == level) {
			list.add(new long[]{order, order});
		}
		long[] lr = list.get(level);
		lr[0] = Math.min(lr[0], order);
		lr[1] = Math.max(lr[1], order);
		dfs(node.left, order * 2 - 1, level + 1, list);
		dfs(node.right, order * 2, level + 1, list);
	}
}
