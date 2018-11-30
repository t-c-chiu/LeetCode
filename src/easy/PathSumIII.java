package easy;

import util.TreeNode;

public class PathSumIII {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.left.left = new TreeNode(-1);
//		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(-3);
		root.right.left = new TreeNode(-2);
//		root.right.right = new TreeNode(4);
//		root.right.right.left = new TreeNode(5);
//		root.right.right.right = new TreeNode(1);
		System.out.println(new PathSumIII().pathSum(root, -1));
	}

	private int max = 0;

	public int pathSum(TreeNode root, int sum) {
		validatePath(root, sum);
		if (root != null) {
			pathSum(root.left, sum);
			pathSum(root.right, sum);
		}
		return max;
	}

	private void validatePath(TreeNode root, int sum) {
		if (root == null)
			return;

		int calculatedVal = sum - root.val;
		if (calculatedVal == 0)
			max++;
		validatePath(root.left, calculatedVal);
		validatePath(root.right, calculatedVal);
	}
}