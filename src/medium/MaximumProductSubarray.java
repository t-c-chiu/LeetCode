package medium;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
		System.out.println(maxProduct(new int[]{7, -5, -3, 6, -1, 2}));
		System.out.println(maxProduct(new int[]{0, 4, 7, 0, -1, -2}));
	}
	
	public static int maxProduct(int[] nums) {
		int res = nums[0], max = nums[0], min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
			res = Math.max(res, max);
		}
		return res;
	}
}
