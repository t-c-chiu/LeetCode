package medium;

public class WiggleSubsequence {
	
	public static void main(String[] args) {
		int res = wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
		System.out.println(res);
	}
	
	public static int wiggleMaxLength(int[] nums) {
		int n = nums.length;
		int[] up = new int[n], down = new int[n];
		up[0] = down[0] = 1;
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1]) {
				up[i] = down[i - 1] + 1;
				down[i] = down[i - 1];
			} else if (nums[i] < nums[i - 1]) {
				down[i] = up[i - 1] + 1;
				up[i] = up[i - 1];
			} else {
				down[i] = down[i - 1];
				up[i] = up[i - 1];
			}
		}
		return Math.max(up[n - 1], down[n - 1]);
	}
}
