package medium;

import util.TreeNode;

public class RangeSumOfBST {
	
	public static void main(String[] args) {
		// 10, 5, 15, 3, 7, null, 18
		TreeNode root = new TreeNode(10);
		TreeNode left = new TreeNode(5);
		TreeNode right = new TreeNode(15);
		root.left = left;
		root.right = right;
		left.left = new TreeNode(3);
		left.right = new TreeNode(7);
		right.right = new TreeNode(18);
		System.out.println(new RangeSumOfBST().rangeSumBST(root, 7, 15));
		System.out.println(new RangeSumOfBST().rangeSumBST(root, 11, 20));
		System.out.println(new RangeSumOfBST().rangeSumBST(root, 2, 4));
	}
	
	//	Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
	//	Output: 32
	//	Example 2:
	//
	//	Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
	//	Output: 23
	public int rangeSumBST(TreeNode root, int L, int R) {
		int sum = 0;
		if (root == null)
			return 0;
		
		int val = root.val;
		if (val >= L && val <= R) {
			sum += val;
			sum += rangeSumBST(root.left, L, R);
			sum += rangeSumBST(root.right, L, R);
		}
		if (val < L)
			return rangeSumBST(root.right, L, R);
		if (val > R)
			return rangeSumBST(root.left, L, R);
		return sum;
	}
}
