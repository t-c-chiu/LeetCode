package easy;

import util.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
	
	public static void main(String[] args) {
		TreeNode res = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
		System.out.println(res);
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}
	
	private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, left, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, right);
		return root;
	}
}
