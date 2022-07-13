package medium;

public class HouseRobberII {
	
	public static void main(String[] args) {
		int res = rob(new int[]{1, 2});
		System.out.println(res);
	}
	
	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
	}
	
	private static int rob(int[] nums, int from, int to) {
		int prev = 0, cur = 0;
		for (int i = from; i <= to; i++) {
			int temp = Math.max(cur, prev + nums[i]);
			prev = cur;
			cur = temp;
		}
		return cur;
	}
}
