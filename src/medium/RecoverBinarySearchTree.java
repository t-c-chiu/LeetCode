package medium;

import util.TreeNode;

public class RecoverBinarySearchTree {
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateRoot(new Integer[]{1, 3, null, null, 2});
		recoverTree(root);
		TreeNode.printVals(root);
	}
	
	static TreeNode firstElement = null;
	static TreeNode secondElement = null;
	static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
	
	public static void recoverTree(TreeNode root) {
		dfs(root);
		int temp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = temp;
	}
	
	private static void dfs(TreeNode node) {
		if (node == null) {
			return;
		}
		dfs(node.left);
		if (firstElement == null && prevElement.val > node.val) {
			firstElement = prevElement;
		}
		if (firstElement != null && prevElement.val > node.val) {
			secondElement = node;
		}
		prevElement = node;
		dfs(node.right);
	}
	
}
