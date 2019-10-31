package medium;

import util.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
		TreeNode root = TreeNode.generateRoot(new Integer[]{1, 2, 5, 3, 4, null, 6});
		test.flatten(root);
		TreeNode.printVals(root);
	}
	
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		
		flatten(root.left);
		
		TreeNode right = root.right;
		if (root.left != null) {
			root.right = root.left;
			TreeNode tmp = root.right;
			while (tmp.right != null)
				tmp = tmp.right;
			tmp.right = right;
			root.left = null;
		}
		
		flatten(right);
	}
}
