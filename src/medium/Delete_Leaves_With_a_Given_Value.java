package medium;

import util.TreeNode;

public class Delete_Leaves_With_a_Given_Value {
	
	public static void main(String[] args) {
		Delete_Leaves_With_a_Given_Value test = new Delete_Leaves_With_a_Given_Value();
		TreeNode res = test.removeLeafNodes(TreeNode.generateRoot(new Integer[]{1, 2, 3, 2, null, 2, 4}), 2);
		System.out.println(res);
	}
	
	public TreeNode removeLeafNodes(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		
		root.left = removeLeafNodes(root.left, target);
		root.right = removeLeafNodes(root.right, target);
		return root.left == null && root.right == null && root.val == target ? null : root;
	}
}
