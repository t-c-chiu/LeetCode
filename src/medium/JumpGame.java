package medium;

public class JumpGame {
	public static void main(String[] args) {
		JumpGame jumpGame = new JumpGame();
		System.out.println(jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
		System.out.println(jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
	}

	public boolean canJump(int[] nums) {
		int reach = nums[0];
		for (int i = 1; i < nums.length && reach >= i; i++) {
			reach = Math.max(reach, i + nums[i]);
		}
		return reach >= nums.length - 1;
	}
}
