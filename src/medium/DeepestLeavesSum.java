package medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
	
	public static void main(String[] args) {
		int res = new DeepestLeavesSum()
				.deepestLeavesSum(TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8}));
		System.out.println(res);
	}
	
	public int deepestLeavesSum(TreeNode root) {
		int res = 0, i;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (i = 0, res = 0; i < size; i++) {
				TreeNode node = queue.poll();
				res += node.val;
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return res;
	}
}
