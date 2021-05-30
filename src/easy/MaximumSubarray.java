package easy;

public class MaximumSubarray {
	public static void main(String[] args) {
		System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
	
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		int currentMax = nums[0];
		int max = nums[0];
		for (int i = 1; i < len; i++) {
			currentMax = Math.max(currentMax + nums[i], nums[i]);
			max = Math.max(max, currentMax);
		}
		return max;
	}
	
}
