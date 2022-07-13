package easy;

import util.TreeNode;

import java.util.Stack;

public class SymmetricTree {
	public static void main(String[] args) {
		boolean res = isSymmetric(TreeNode.generateRoot(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
		System.out.println(res);
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);
		while (!stack.isEmpty()) {
			TreeNode n1 = stack.pop();
			TreeNode n2 = stack.pop();
			if (n1 == null && n2 == null) {
				continue;
			}
			if (n1 == null || n2 == null || n1.val != n2.val) {
				return false;
			}
			stack.push(n1.left);
			stack.push(n2.right);
			stack.push(n1.right);
			stack.push(n2.left);
		}
		return true;
	}
//	public static boolean isSymmetric(TreeNode root) {
//		if (root == null) {
//			return true;
//		}
//		return helper(root.left, root.right);
//	}
//
//	private static boolean helper(TreeNode left, TreeNode right) {
//		if (left == null && right == null) {
//			return true;
//		}
//		if (left == null || right == null || left.val != right.val) {
//			return false;
//		}
//		return helper(left.left, right.right) && helper(left.right, right.left);
//	}
}
