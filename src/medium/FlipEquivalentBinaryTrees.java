package medium;

import util.TreeNode;

public class FlipEquivalentBinaryTrees {
	
	public static void main(String[] args) {
		FlipEquivalentBinaryTrees test = new FlipEquivalentBinaryTrees();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.left.right.left = new TreeNode(7);
		root1.left.right.right = new TreeNode(8);
		root1.right = new TreeNode(3);
		root1.right.left = new TreeNode(6);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(3);
		root2.left.right = new TreeNode(6);
		root2.right = new TreeNode(2);
		root2.right.left = new TreeNode(4);
		root2.right.right = new TreeNode(5);
		root2.right.right.left = new TreeNode(8);
		root2.right.right.right = new TreeNode(7);
		
		System.out.println(test.flipEquiv(root1, root2));
	}
	
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null)
			return root1 == root2;
		if (root1.val != root2.val)
			return false;
		return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
				flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
	}
}
