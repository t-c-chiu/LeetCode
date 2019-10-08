package medium;

import util.TreeNode;

public class MaximumBinaryTree {
	
	public static void main(String[] args) {
		MaximumBinaryTree test = new MaximumBinaryTree();
		TreeNode root = test.constructMaximumBinaryTree(new int[]{2, 4, 7, 3, 9, 6, 1, 8, 5});
		System.out.println(root);
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree(nums, 0, nums.length);
	}
	
	private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
		if (start == end)
			return null;
		
		int maxIdx = start;
		for (int i = start; i < end; i++)
			if (nums[i] > nums[maxIdx])
				maxIdx = i;
		TreeNode node = new TreeNode(nums[maxIdx]);
		node.left = constructMaximumBinaryTree(nums, start, maxIdx);
		node.right = constructMaximumBinaryTree(nums, maxIdx + 1, end);
		return node;
	}
}
