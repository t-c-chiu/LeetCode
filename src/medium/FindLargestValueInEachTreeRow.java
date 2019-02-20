package medium;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class FindLargestValueInEachTreeRow {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(9);
		System.out.println(new FindLargestValueInEachTreeRow().largestValues(root));
	}

	//	Input:
	//     1
	//    / \
	//   3   2
	//  / \   \
	// 5   3   9
	//
	//	Output: [1, 3, 9]
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		helper(result, root, 0);
		return result;
	}

	private void helper(List<Integer> result, TreeNode root, int level) {
		if (root == null)
			return;
		if (level == result.size())
			result.add(root.val);
		else
			result.set(level, Math.max(root.val, result.get(level)));
		helper(result, root.left, level + 1);
		helper(result, root.right, level + 1);
	}
}
