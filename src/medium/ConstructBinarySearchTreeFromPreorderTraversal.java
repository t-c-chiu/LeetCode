package medium;

import util.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
	
	public static void main(String[] args) {
		ConstructBinarySearchTreeFromPreorderTraversal test = new ConstructBinarySearchTreeFromPreorderTraversal();
		System.out.println(test.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
	}
	
	private int i = 0;
	
	public TreeNode bstFromPreorder(int[] preorder) {
		return constructTree(preorder, Integer.MAX_VALUE);
	}
	
	private TreeNode constructTree(int[] preorder, int bound) {
		if (i >= preorder.length || preorder[i] > bound)
			return null;
		
		TreeNode root = new TreeNode(preorder[i++]);
		root.left = constructTree(preorder, root.val);
		root.right = constructTree(preorder, bound);
		return root;
	}
}
