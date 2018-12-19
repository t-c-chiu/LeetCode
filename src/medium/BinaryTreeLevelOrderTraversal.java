package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		right.left = new TreeNode(15);
		right.right = new TreeNode(7);
		root.right = right;
		for (List<Integer> list : new BinaryTreeLevelOrderTraversal().levelOrder(root))
			System.out.println(list);
	}
	
	//	 3
	//  / \
	// 9  20
	//   /  \
	//  15   7
	
	//  [3],
	//  [9,20],
	//  [15,7]
	private List<List<Integer>> result = new ArrayList<>();
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		helper(root, 0);
		return result;
	}
	
	private void helper(TreeNode root, int level) {
		if (root == null)
			return;
		
		List<Integer> list;
		if (result.size() < level + 1) {
			list = new ArrayList<>();
			result.add(list);
		} else
			list = result.get(level);
		
		list.add(root.val);
		helper(root.left, level + 1);
		helper(root.right, level + 1);
	}
}
