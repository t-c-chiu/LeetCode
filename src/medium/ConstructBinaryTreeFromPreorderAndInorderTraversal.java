package medium;

import util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	public static void main(String[] args) {
		TreeNode res = buildTree(new int[]{3, 9, 8, 6, 20, 15, 7}, new int[]{8, 9, 6, 3, 15, 20, 7});
		TreeNode.printVals(res);
	}
	
	//      3
	//    /   \
	//   9    20
	//  / \  /  \
	// 8  6 15   7
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
	}
	
	// {3, 9, 8, 6, 20, 15, 7}
	// {8, 9, 6, 3, 15, 20, 7}
	private static TreeNode buildTree(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
		if (preIndex == preorder.length || inStart > inEnd) {
			return null;
		}
		int val = preorder[preIndex], i;
		TreeNode node = new TreeNode(val);
		for (i = inStart; i <= inEnd; i++) {
			if (inorder[i] == val) {
				break;
			}
		}
		node.left = buildTree(preorder, inorder, preIndex + 1, inStart, i - 1);
		node.right = buildTree(preorder, inorder, preIndex + i - inStart + 1, i + 1, inEnd);
		return node;
	}
	
}
