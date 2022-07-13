package medium;

public class MaximizeTheTopmostElementAfterKMoves {
	
	public static void main(String[] args) {
		int res = maximumTop(new int[]{5, 2, 2, 4, 0, 6}, 4);
		System.out.println(res);
	}
	
	/**
	 * 1 5 3 - 2
	 * 1 2 4 3 - 3
	 */
	public static int maximumTop(int[] nums, int k) {
		int n = nums.length;
		if (n == 1) {
			return k % 2 == 1 ? -1 : nums[0];
		}
		int res = -1;
		for (int i = 0; i < Math.min(k - 1, n); i++) {
			res = Math.max(res, nums[i]);
		}
		if (k < n) {
			res = Math.max(res, nums[k]);
		}
		return res;
	}
}
