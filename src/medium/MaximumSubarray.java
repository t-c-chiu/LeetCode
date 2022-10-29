package medium;

public class MaximumSubarray {
	public static void main(String[] args) {
		int res = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
		System.out.println(res);
	}
	
	public static int maxSubArray(int[] nums) {
		int max = nums[0], res = max;
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max + nums[i], nums[i]);
			res = Math.max(res, max);
		}
		return res;
	}
	
}
