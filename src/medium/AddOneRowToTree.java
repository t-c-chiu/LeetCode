package medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
	
	public static void main(String[] args) {
		TreeNode res = addOneRow(TreeNode.generateRoot(new Integer[]{4, 2, 6, 3, 1, 5}), 1, 2);
		TreeNode.printVals(res);
	}
	
	public static TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth == 1) {
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty() && depth > 2) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			depth--;
		}
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode left = node.left;
			TreeNode right = node.right;
			node.left = new TreeNode(val);
			node.right = new TreeNode(val);
			node.left.left = left;
			node.right.right = right;
		}
		return root;
	}
}
