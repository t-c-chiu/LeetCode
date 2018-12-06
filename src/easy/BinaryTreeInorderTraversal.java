package easy;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(root));
	}

	// 1, 3, 2
	private List<Integer> result = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			result.add(root.val);
			inorderTraversal(root.right);
		}
		return result;
	}
}
