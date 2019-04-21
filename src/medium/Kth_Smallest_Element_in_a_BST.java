package medium;

import util.TreeNode;

import java.util.Stack;

public class Kth_Smallest_Element_in_a_BST {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);
		root.right = new TreeNode(5);
		
		Kth_Smallest_Element_in_a_BST test = new Kth_Smallest_Element_in_a_BST();
//		System.out.println(test.kthSmallest2(root, 1));
//		System.out.println(test.kthSmallest2(root, 2));
//		System.out.println(test.kthSmallest2(root, 3));
//		System.out.println(test.kthSmallest2(root, 4));
		System.out.println(test.kthSmallest2(root, 5));
	}
	
	//    4
	//   / \
	//  1   5
	//   \
	//    2
	//     \
	//      3
	//	Output: 1
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0)
				return root.val;
			root = root.right;
		}
		return 0;
	}
	
	
	private int res, count;
	
	public int kthSmallest2(TreeNode root, int k) {
		helper(root, k);
		return res;
	}
	
	private void helper(TreeNode root, int k) {
		if (root == null || count > k)
			return;
		helper(root.left, k);
		if (++count == k) {
			res = root.val;
			return;
		}
		helper(root.right, k);
	}
}
