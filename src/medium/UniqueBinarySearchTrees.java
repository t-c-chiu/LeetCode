package medium;

public class UniqueBinarySearchTrees {
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
		final int res = test.numTrees(5);
		System.out.println(res);
	}
	
	// nums[n] = 長度為n且值有順序的BST數量, 例如123組成的BST或345組成的BST數量都是nums[3]
	// 1 <= i <= n, nums[i] = nums[i - 1] * nums[n - i], 左半邊的BST數量 * 右半邊的BST數量
	public int numTrees(int n) {
		int[] nums = new int[n + 1];
		nums[0] = nums[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				nums[i] += nums[j - 1] * nums[i - j];
			}
		}
		return nums[n];
	}
}
