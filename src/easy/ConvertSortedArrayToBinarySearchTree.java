package easy;

import util.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
	
	public static void main(String[] args) {
		TreeNode res = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
		System.out.println(res);
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	
	private static TreeNode helper(int[] nums, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, lo, mid - 1);
		node.right = helper(nums, mid + 1, hi);
		return node;
	}
}
