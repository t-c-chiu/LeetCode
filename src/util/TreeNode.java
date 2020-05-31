package util;

import java.util.*;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x) {
		val = x;
	}
	
	public static TreeNode generateRoot(Integer[] vals) {
		if (vals.length == 0)
			return null;
		
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(vals[0]);
		queue.offer(root);
		for (int i = 1; i < vals.length; i += 2) {
			TreeNode node = queue.poll();
			if (vals[i] != null) {
				node.left = new TreeNode(vals[i]);
				queue.offer(node.left);
			}
			if (i + 1 < vals.length && vals[i + 1] != null) {
				node.right = new TreeNode(vals[i + 1]);
				queue.offer(node.right);
			}
		}
		return root;
	}
	
	public static void printVals(TreeNode root) {
		Stack<Integer> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<>();
		stack.add(root.val);
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				stack.add(node.left.val);
				queue.offer(node.left);
			} else
				stack.add(null);
			
			if (node.right != null) {
				stack.add(node.right.val);
				queue.offer(node.right);
			} else
				stack.add(null);
		}
		
		while (stack.peek() == null)
			stack.pop();
		
		System.out.println(stack);
	}
	
	@Override
	public String toString() {
		return "TreeNode{" +
				"val=" + val +
				", left=" + left +
				", right=" + right +
				'}';
	}
}
