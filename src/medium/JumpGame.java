package medium;

public class JumpGame {
	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
		System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
	}
	
	public static boolean canJump(int[] nums) {
		int n = nums.length;
		for (int i = 0, max = 0; i <= max && i < n; i++) {
			max = Math.max(max, i + nums[i]);
			if (max >= n - 1) {
				return true;
			}
		}
		return false;
	}
}
