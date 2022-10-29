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
	
	private static TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2, val = nums[mid];
		TreeNode node = new TreeNode(val);
		node.left = helper(nums, left, mid - 1);
		node.right = helper(nums, mid + 1, right);
		return node;
	}
}
