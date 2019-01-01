package easy;

import util.TreeNode;

public class PathSum {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		System.out.println(new PathSum().hasPathSum(root, 22));
	}
	
	//       5
	//      / \
	//     4   8
	//    /   / \
	//   11  13  4
	//  /  \      \
	// 7    2      1
	// sum: 22
	// return true: 5 + 4 + 11 + 2 = 22
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		sum -= root.val;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (sum == 0 && left == null && right == null)
			return true;
		return hasPathSum(left, sum) || hasPathSum(right, sum);
	}
}
