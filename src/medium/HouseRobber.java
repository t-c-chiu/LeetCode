package medium;

public class HouseRobber {
	
	public static void main(String[] args) {
		int res = rob(new int[]{2, 7, 9, 4, 1});
		System.out.println(res);
	}
	
	public static int rob(int[] nums) {
		int prevprev = 0, prev = 0;
		for (int i = 0; i < nums.length; i++) {
			int max = Math.max(prevprev + nums[i], prev);
			prevprev = prev;
			prev = max;
		}
		return prev;
	}

//	public static int rob(int[] nums) {
//		int n = nums.length;
//		if (n == 1) {
//			return nums[0];
//		}
//		int[] max = new int[n];
//		max[0] = nums[0];
//		max[1] = Math.max(nums[0], nums[1]);
//		for (int i = 2; i < n; i++) {
//			max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
//		}
//		return max[n - 1];
//	}
}
