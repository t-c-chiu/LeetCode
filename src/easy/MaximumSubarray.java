package easy;

public class MaximumSubarray {
	public static void main(String[] args) {
		System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}

	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int currentMax = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			currentMax = Math.max(currentMax + num, num);
			max = Math.max(max, currentMax);
		}
		return max;
	}
}
