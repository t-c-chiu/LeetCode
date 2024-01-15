package medium;

import util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	public static void main(String[] args) {
		TreeNode res = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
		TreeNode.printVals(res);
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, inorder, 0, 0, inorder.length - 1);
	}
	
	private static TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
		if (preStart == preorder.length || inStart > inEnd) {
			return null;
		}
		int val = preorder[preStart];
		TreeNode node = new TreeNode(val);
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == val) {
				node.left = helper(preorder, inorder, preStart + 1, inStart, i - 1);
				node.right = helper(preorder, inorder, preStart + i - inStart + 1, i + 1, inEnd);
			}
		}
		return node;
	}
	
}
