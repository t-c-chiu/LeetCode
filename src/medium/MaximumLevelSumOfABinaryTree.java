package medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
	
	public static void main(String[] args) {
		int res = maxLevelSum(TreeNode.generateRoot(new Integer[]{1, 7, 0, 7, -8}));
		System.out.println(res);
	}
	
	public static int maxLevelSum(TreeNode root) {
		int res = 1, level = 1, max = Integer.MIN_VALUE;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int sum = 0;
			for (int i = queue.size(); i > 0; i--) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			if (sum > max) {
				max = sum;
				res = level;
			}
			level++;
		}
		return res;
	}
}
