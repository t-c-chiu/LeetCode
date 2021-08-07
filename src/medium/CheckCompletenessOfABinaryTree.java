package medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
	
	public static void main(String[] args) {
		boolean res = isCompleteTree(TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, 5, null, 7}));
		System.out.println(res);
	}
	
	public static boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (queue.peek() != null) {
			TreeNode node = queue.poll();
			queue.offer(node.left);
			queue.offer(node.right);
		}
		while (!queue.isEmpty() && queue.peek() == null) {
			queue.poll();
		}
		return queue.isEmpty();
	}
}
