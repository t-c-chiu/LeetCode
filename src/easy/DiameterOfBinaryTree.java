package easy;

import util.TreeNode;

public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(4);
		System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
		
	}
	
	private int max;
	
	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;
	}
	
	private int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		max = Math.max(max, left + right);
		
		return Math.max(left, right) + 1;
	}
}
