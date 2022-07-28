package medium;

import util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
	
	public static void main(String[] args) {
		TreeNode res = constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
		TreeNode.printVals(res);
	}
	
	static int preIndex, postIndex;
	
	public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		int val = preorder[preIndex++];
		TreeNode node = new TreeNode(val);
		if (val != postorder[postIndex]) {
			node.left = constructFromPrePost(preorder, postorder);
		}
		if (val != postorder[postIndex]) {
			node.right = constructFromPrePost(preorder, postorder);
		}
		postIndex++;
		return node;
	}
}
