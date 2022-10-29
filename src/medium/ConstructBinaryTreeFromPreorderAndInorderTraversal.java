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
	
	private static TreeNode helper(int[] preorder, int[] inorder, int i, int inStart, int inEnd) {
		if (i == preorder.length || inStart > inEnd) {
			return null;
		}
		int val = preorder[i];
		TreeNode node = new TreeNode(val);
		for (int j = inStart; j <= inEnd; j++) {
			if (val == inorder[j]) {
				node.left = helper(preorder, inorder, i + 1, inStart, j - 1);
				node.right = helper(preorder, inorder, i + j - inStart + 1, j + 1, inEnd);
				break;
			}
		}
		return node;
	}
	
}
