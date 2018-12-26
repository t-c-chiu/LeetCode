package easy;

import util.TreeNode;

public class TrimABinarySearchTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root = new TrimABinarySearchTree().trimBST(root, 1, 3);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.left.left.val);
	}
	//	Input:
	//    3
	//   / \
	//  0   4
	//   \
	//    2
	//   /
	//  1
	//	L = 1
	//	R = 3

	//	Output:
	//      3
	//     /
	//    2
	//   /
	//  1
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)
			return null;
		int val = root.val;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (val < L) {
			root = trimBST(right, L, R);
		} else if (val > R) {
			root = trimBST(left, L, R);
		} else {
			root.left = trimBST(left, L, R);
			root.right = trimBST(right, L, R);
		}
		return root;
	}
}
