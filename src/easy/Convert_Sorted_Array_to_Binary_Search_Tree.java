package easy;

import util.TreeNode;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
	public static void main(String[] args) {
		Convert_Sorted_Array_to_Binary_Search_Tree test = new Convert_Sorted_Array_to_Binary_Search_Tree();
		test.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return generateBST(nums, 0, nums.length - 1);
	}
	
	private TreeNode generateBST(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = generateBST(nums, left, mid - 1);
		root.right = generateBST(nums, mid + 1, right);
		return root;
	}
}
