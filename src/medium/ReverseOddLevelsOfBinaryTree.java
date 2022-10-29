package medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseOddLevelsOfBinaryTree {
	
	public static void main(String[] args) {
		TreeNode res = reverseOddLevels(TreeNode.generateRoot(new Integer[]{2, 3, 5, 8, 13, 21, 34}));
		TreeNode.printVals(res);
	}
	
	public static TreeNode reverseOddLevels(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		boolean isEven = true;
		queue.offer(root);
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				TreeNode node = queue.poll();
				if (!isEven) {
					node.val = stack.pop();
				}
				if (node.left != null) {
					queue.offer(node.left);
					if (isEven) {
						stack.push(node.left.val);
					}
				}
				if (node.right != null) {
					queue.offer(node.right);
					if (isEven) {
						stack.push(node.right.val);
					}
				}
			}
			isEven = !isEven;
		}
		return root;
	}
}
