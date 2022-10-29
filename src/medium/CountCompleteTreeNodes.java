package medium;

import util.TreeNode;

public class CountCompleteTreeNodes {
	
	public static void main(String[] args) {
		int res = countNodes(TreeNode.generateRoot(new Integer[]{1, 2, 3, 4, 5, 6}));
		System.out.println(res);
	}
	
	public static int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		if (left == right) {
			return (int) (Math.pow(2, left) + countNodes(root.right));
		} else {
			return (int) (Math.pow(2, right) + countNodes(root.left));
		}
	}
	
	private static int getDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + getDepth(node.left);
	}
}
