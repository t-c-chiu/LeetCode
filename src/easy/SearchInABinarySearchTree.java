package easy;

import util.TreeNode;

public class SearchInABinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		root.left = left;
		left.left = new TreeNode(1);
		left.right = new TreeNode(3);
		root.right = new TreeNode(7);

		TreeNode result = new SearchInABinarySearchTree().searchBST(root, 2);
		System.out.println(result.val);
		System.out.println(result.left.val);
		System.out.println(result.right.val);
	}

	//     4
	//    / \
	//   2   7
	//  / \
	// 1   3
	//   val: 2

	//   2
	//  / \
	// 1   3
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return null;
		int rootVal = root.val;
		if (rootVal == val)
			return root;
		return searchBST(rootVal > val ? root.left : root.right, val);
	}
}
